package zakir_bus;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import zakir_bus_data.SQLConnection;

public class NewSeat extends JFrame {

	private JButton[][] seatButtons;
	private JButton submitButton;
	JButton Exit;
	JButton bticket;
	static String s;

	public NewSeat(int numRows, int numCols) {
		setBounds(100, 100, 600, 400);
		getContentPane().setBackground(Color.white);
		setLayout(new GridLayout(numRows + 1, numCols));

		seatButtons = new JButton[numRows][numCols];

		/*
		 * for (int row = 0; row < numRows; row++) { for (int col = 0; col < numCols;
		 * col++) { System.out.println("["+row+"]["+col+"]"); seatButtons[row][col] =
		 * new JButton("Seat " + (row * numCols + col + 1));
		 * seatButtons[row][col].setBackground(Color.green);
		 * seatButtons[row][col].addActionListener(new SeatButton());
		 * add(seatButtons[row][col]); } }
		 */
		// System.out.println(seatButtons[5][5].getText());

		try {
			SQLConnection c = new SQLConnection();
			String Query = "Select * from busbooking_tbl";
			PreparedStatement stm = c.con.prepareStatement(Query);
			ResultSet res = stm.executeQuery();

			for (int row = 0; row < numRows; row++) {
				for (int col = 0; col < numCols; col++) {
					// System.out.println("[" + row + "][" + col + "]");
					seatButtons[row][col] = new JButton("Seat " + (row * numCols + col + 1));
					// seatButtons[row][col].setBackground(Color.green);
					while (res.next()) {
						String setsta = res.getString(3);
						// System.out.println(setsta);
						if (setsta.equalsIgnoreCase("Booked")) {
							seatButtons[row][col].setBackground(Color.red);
							break;
						} else {
							seatButtons[row][col].setBackground(Color.green);
							break;
						}

					}

					seatButtons[row][col].addActionListener(new SeatButton());
					add(seatButtons[row][col]);
				}
			}
		} catch (SQLException j) {
			j.printStackTrace();
		}

		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.black);
		submitButton.setForeground(Color.white);
		submitButton.addActionListener(new SubmitButton());
		add(submitButton);

		bticket = new JButton("BusTicket");
		bticket.setBackground(Color.black);
		bticket.setForeground(Color.white);
		bticket.addActionListener(new Busticket());
		add(bticket);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public  class SeatButton implements ActionListener {
		//static String g;
		// static Color s;

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton seatButton = (JButton) e.getSource();
			s = seatButton.getText();
			// s = seatButton.getBackground();
			// System.out.println(s);
			// System.out.println(g);
			if (seatButton.getBackground() == Color.GREEN) {
				seatButton.setBackground(Color.RED);
			} else {
				JOptionPane.showInternalMessageDialog(null, "Already Booked Ticket");
			}
		}
	}

	private class SubmitButton extends SeatButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				SQLConnection c = new SQLConnection();
				String Query = "update  busbooking_tbl  set booking_Status = 'Booked' Where Seat_num = '" + s + "'";
				// System.out.println(g);
				PreparedStatement stm = c.con.prepareStatement(Query);
				// stm.setString(2, st);
				// stm.setString(3, "Booked");
				int res = stm.executeUpdate();
				if (res > 0) {
					JOptionPane.showMessageDialog(null, "successfully booked Ticket");
				} else {
					System.out.println("Not successfully booking");
				}
			} catch (SQLException j) {
				j.printStackTrace();
			}
		}
	}

	private class Busticket implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

				BusTicket bt = new BusTicket();
				setVisible(false);
				bt.setVisible(true);
			
		}

	}
	public static void Usel_sea() {
		int res = 0;
		for(int i=1;i<=36 ;i++) {
		try {
			SQLConnection c = new SQLConnection();
			String Query = "update  busbooking_tbl  set booking_Status = '-' Where id = '"+i+"'";

			PreparedStatement stm = c.con.prepareStatement(Query);
			//stm.setInt(1, i);
			//String k = "seat "+i;
			//stm.setString(2, k);
			//stm.setString(3, "-");

			 res = stm.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		if(res>0) {
			JOptionPane.showMessageDialog(null, "Successfully Unselected seat");
			//setVisible(false);
			
		}else {
			System.out.println("Error");
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NewSeat s = new NewSeat(6, 6);
		s.setVisible(true);
	}

}
