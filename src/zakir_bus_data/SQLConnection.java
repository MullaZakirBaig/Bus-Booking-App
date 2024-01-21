package zakir_bus_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConnection {

	public Connection con;

	public SQLConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/zakirbus";
			String user = "root";
			String psd = "Zakir123@";

			con = DriverManager.getConnection(url, user, psd);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
