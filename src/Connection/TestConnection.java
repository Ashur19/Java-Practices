package Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	public static void main(String[] args) {

		ConnectionMySQL conn = new ConnectionMySQL();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		System.out.println("The Spearhead Squadron is made up of:");

		try {

			cn = conn.connect();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM spearhead");
			while (rs.next()) {

				int ID = rs.getInt(1);
				String Name = rs.getString(2);
				String Codename = rs.getString(3);
				String Gender = rs.getString(4);
				String Squadron_Position = rs.getString(5);
				String Platoon_Number = rs.getString(6);
				String Platoon_Role = rs.getString(7);

				System.out.println(ID + " - " + Name + " - " + Codename + " - " + Gender + " - " + Squadron_Position
						+ " - " + Platoon_Number + " - " + Platoon_Role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stm != null) {
					stm.close();
				}

				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
