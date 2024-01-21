package zakir_bus_data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reg_data extends SQLConnection {
	
	public String username;
	public String gender;
	public String email;
	public String password;
	public String con_password;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void reg() {
		try {
			String Query = "INSERT INTO registerbus (UserName, Gender, Email, Password_f, Con_password) VALUES (?, ?, ?, ?, ?)";
					
			PreparedStatement stm =con.prepareStatement(Query);
			stm.setString(1, username);
			stm.setString(2, gender);
			stm.setString(3, email);
			stm.setString(4, password);
			stm.setString(5, con_password);
			int res = stm.executeUpdate();
			if(res>0) {
				System.out.println("Successfully added");
			}else {
				System.out.println("not Successfully added");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
