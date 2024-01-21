package zakir_bus;

import java.sql.PreparedStatement;

import zakir_bus_data.SQLConnection;

public class Zakir {
	
	public void Usel_sea() {
		for(int i=1;i<=36 ;i++) {
		try {
			SQLConnection c = new SQLConnection();
			String Query = "update  busbooking_tbl  set Seat_num = 'seat "+i+"' Where id = '"+i+"'";

			PreparedStatement stm = c.con.prepareStatement(Query);
			//stm.setInt(1, i);
			//String k = "seat "+i;
			//stm.setString(2, k);
			//stm.setString(3, "-");

			int res = stm.executeUpdate();
	//	System.out.println(res);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		System.out.println("complete");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Zakir z = new Zakir();
		//z.setteble();
	}

}
