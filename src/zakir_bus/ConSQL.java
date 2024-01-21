package zakir_bus;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConSQL {
	Connection con;
	public ConSQL(){
		try {
			String url = "jdbc:mysql://localhost:3306/busbooking";
			String user = "root";
			String psd = "Zakir123@";
			
			con = DriverManager.getConnection(url, user, psd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
