package zakir_bus_data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_data extends SQLConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login_data l = new Login_data();
		l.loging_data();
		
	}
	
	public void loging_data() {
		try {
			String Query = "Select * from registerbus";
			PreparedStatement stm =con.prepareStatement(Query);
			ResultSet res = stm.executeQuery();
			System.out.println(res.getRow());
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
