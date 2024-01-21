package zakir_bus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import zakir_bus_data.SQLConnection;

public class BusTicket extends JFrame implements ActionListener {

	JButton bck;

	public BusTicket() {
		// Reg_data rg = new Reg_data();
		getContentPane().setBackground(Color.white);
		setBounds(100, 100, 600, 400);
		setLayout(null);

		JLabel logn = new JLabel("Bus Ticket Details");
		logn.setBounds(220, 20, 200, 30);
		logn.setForeground(Color.red);
		logn.setFont(new Font("serit", Font.BOLD, 20));
		add(logn);

		JLabel user = new JLabel("UserName :");
		user.setBounds(100, 60, 100, 25);
		user.setFont(new Font("serit", Font.BOLD, 15));
		add(user);
		String username = Reg_Table.userN;
		JLabel userm = new JLabel(username);
		userm.setBounds(250, 60, 100, 25);
		userm.setFont(new Font("serit", Font.BOLD, 15));
		add(userm);

		JLabel gender = new JLabel("Gender :");
		gender.setBounds(100, 90, 100, 25);
		gender.setFont(new Font("serit", Font.BOLD, 15));
		add(gender);

		String genderr = Reg_Table.Gender;
		JLabel genderm = new JLabel(genderr);
		genderm.setBounds(250, 90, 100, 25);
		genderm.setFont(new Font("serit", Font.BOLD, 15));
		add(genderm);

		JLabel email = new JLabel("Email :");
		email.setBounds(100, 120, 100, 25);
		email.setFont(new Font("serit", Font.BOLD, 15));
		add(email);

		String emailid = Reg_Table.Email;
		JLabel emailm = new JLabel(emailid);
		emailm.setBounds(250, 120, 150, 25);
		emailm.setFont(new Font("serit", Font.BOLD, 15));
		add(emailm);

		JLabel From = new JLabel("From To :");
		From.setBounds(100, 150, 100, 25);
		From.setFont(new Font("serit", Font.BOLD, 15));
		add(From);

		String fromm = BusSearch.fromtt;
		JLabel from1 = new JLabel(fromm);
		from1.setBounds(250, 150, 100, 25);
		from1.setFont(new Font("serit", Font.BOLD, 15));
		add(from1);

		JLabel goingt = new JLabel("Going To :");
		goingt.setBounds(100, 180, 100, 25);
		goingt.setFont(new Font("serit", Font.BOLD, 15));
		add(goingt);

		String goingtt = BusSearch.goingtt;
		JLabel goingtt1 = new JLabel(goingtt);
		goingtt1.setBounds(250, 180, 100, 25);
		goingtt1.setFont(new Font("serit", Font.BOLD, 15));
		add(goingtt1);

		JLabel bs = new JLabel("Bus Name :");
		bs.setBounds(100, 210, 100, 25);
		bs.setFont(new Font("serit", Font.BOLD, 15));
		add(bs);

		String bsn1 = Table.BS;
		JLabel bsn = new JLabel(bsn1);
		bsn.setBounds(250, 210, 100, 25);
		bsn.setFont(new Font("serit", Font.BOLD, 15));
		add(bsn);

		JLabel ps = new JLabel("Price :");
		ps.setBounds(100, 240, 100, 25);
		ps.setFont(new Font("serit", Font.BOLD, 15));
		add(ps);

		String psn1 = Table.PR;
		JLabel psn = new JLabel(psn1);
		psn.setBounds(250, 240, 100, 25);
		psn.setFont(new Font("serit", Font.BOLD, 15));
		add(psn);

		JLabel dt = new JLabel("Date & Time :");
		dt.setBounds(100, 270, 100, 25);
		dt.setFont(new Font("serit", Font.BOLD, 15));
		add(dt);

		String dt11 = Table.DT;
		JLabel dt1 = new JLabel(dt11);
		dt1.setBounds(250, 270, 150, 25);
		dt1.setFont(new Font("serit", Font.BOLD, 15));
		add(dt1);

		JLabel seat = new JLabel("Seat No :");
		seat.setBounds(100, 300, 100, 25);
		seat.setFont(new Font("serit", Font.BOLD, 15));
		add(seat);

		String seatm = NewSeat.s;
		JLabel seat1 = new JLabel(seatm);
		seat1.setBounds(250, 300, 100, 25);
		seat1.setFont(new Font("serit", Font.BOLD, 15));
		add(seat1);

		bck = new JButton("Back");
		bck.setBounds(450, 320, 100, 30);
		bck.setBackground(Color.black);
		bck.setForeground(Color.white);
		bck.addActionListener(this);
		add(bck);

	}

	public static void dataticket() {
		try {
			SQLConnection c = new SQLConnection();
			String Query = "Select * from bustable";
			PreparedStatement stm = c.con.prepareStatement(Query);
			ResultSet res = stm.executeQuery();

			// model.setRowCount(0);
			while (res.next()) {
				res.getString(2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BusTicket bt = new BusTicket();
		bt.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		SubClass mc = new SubClass();
		setVisible(false);
		mc.setVisible(true);
	}

}
