package zakir_bus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import zakir_bus_data.SQLConnection;

public class BusAdd extends JFrame implements ActionListener {

	JTextField busnt;
	JTextField fromtot;
	JTextField goingtt;
	JTextField pricet;
	JTextField dtimet;

	JButton sub;
	JButton can;

	public BusAdd() {
		getContentPane().setBackground(Color.white);
		setBounds(100, 100, 600, 400);
		setLayout(null);

		JLabel maintitle = new JLabel("Bus Details Adding");
		maintitle.setBounds(150, 10, 350, 35);
		maintitle.setFont(new Font("serit", Font.BOLD, 30));
		maintitle.setForeground(Color.blue);
		add(maintitle);

		JLabel busn = new JLabel("Bus Name :");
		busn.setBounds(100, 60, 100, 25);
		busn.setFont(new Font("serit", Font.BOLD, 15));
		add(busn);

		busnt = new JTextField();
		busnt.setBounds(250, 60, 200, 25);
		busnt.setFont(new Font("serit", Font.BOLD, 15));
		add(busnt);

		JLabel fromto = new JLabel("From :");
		fromto.setBounds(100, 90, 100, 25);
		fromto.setFont(new Font("serit", Font.BOLD, 15));
		add(fromto);

		fromtot = new JTextField();
		fromtot.setBounds(250, 90, 200, 25);
		fromtot.setFont(new Font("serit", Font.BOLD, 15));
		add(fromtot);

		JLabel goingt = new JLabel("Going :");
		goingt.setBounds(100, 120, 100, 25);
		goingt.setFont(new Font("serit", Font.BOLD, 15));
		add(goingt);

		goingtt = new JTextField();
		goingtt.setBounds(250, 120, 200, 25);
		goingtt.setFont(new Font("serit", Font.BOLD, 15));
		add(goingtt);

		JLabel price = new JLabel("Price / Seat :");
		price.setBounds(100, 150, 100, 25);
		price.setFont(new Font("serit", Font.BOLD, 15));
		add(price);

		pricet = new JTextField();
		pricet.setBounds(250, 150, 200, 25);
		pricet.setFont(new Font("serit", Font.BOLD, 15));
		add(pricet);

		JLabel DandT = new JLabel("Date & Time :");
		DandT.setBounds(100, 180, 100, 25);
		DandT.setFont(new Font("serit", Font.BOLD, 15));
		add(DandT);

		dtimet = new JTextField();
		dtimet.setBounds(250, 180, 200, 25);
		dtimet.setFont(new Font("serit", Font.BOLD, 15));
		add(dtimet);

		sub = new JButton("Submit");
		sub.setBounds(150, 240, 100, 30);
		sub.setBackground(Color.black);
		sub.setForeground(Color.white);
		sub.addActionListener(this);
		add(sub);

		can = new JButton("Cancel");
		can.setBounds(280, 240, 100, 30);
		can.setBackground(Color.black);
		can.setForeground(Color.white);
		can.addActionListener(this);
		add(can);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BusAdd ba = new BusAdd();
		ba.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == sub) {
			System.out.println("sub");

			SQLConnection c = new SQLConnection();

			String busname = busnt.getText();
			String fromt = fromtot.getText();
			String goingt = goingtt.getText();
			String price = pricet.getText();
			String datetime = dtimet.getText();

			try {
				String Query = "INSERT INTO bustable (BusName, Fromto, Goingto, Price, Dates_times) VALUES (?, ?, ?, ?, ?)";

				PreparedStatement stm = c.con.prepareStatement(Query);
				stm.setString(1, busname);
				stm.setString(2, fromt);
				stm.setString(3, goingt);
				stm.setString(4, price);
				stm.setString(5, datetime);
				int res = stm.executeUpdate();
				if (res > 0) {
					JOptionPane.showMessageDialog(null, "Successfully Added");
					System.out.println("Successfully added");
				} else {
					System.out.println("not Successfully added");
					JOptionPane.showMessageDialog(null, "Successfully Not Added");
				}
			} catch (SQLException j) {
				j.printStackTrace();
			}

		} else {
			System.out.println("cancel");
			setVisible(false);
			Admin a = new Admin();
			a.setVisible(true);
		}
	}

}
