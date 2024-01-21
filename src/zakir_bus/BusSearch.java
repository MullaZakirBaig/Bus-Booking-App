package zakir_bus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import zakir_bus_data.SQLConnection;

public class BusSearch extends JFrame implements ActionListener {

	JButton subcrh;
	JButton cancrh;

	JTextField fromt;
	JTextField got;
	
	
	public static String fromtt;
	public static String goingtt;

	public BusSearch() {

		getContentPane().setBackground(Color.white);
		setBounds(100, 100, 600, 400);
		setLayout(null);

		JLabel logn = new JLabel("Bus Searching :");
		logn.setBounds(50, 70, 160, 30);
		logn.setFont(new Font("serit", Font.BOLD, 20));
		add(logn);

		JLabel user = new JLabel("From To");
		user.setBounds(50, 110, 100, 30);
		user.setFont(new Font("serit", Font.BOLD, 15));
		add(user);

		fromt = new JTextField();
		fromt.setBounds(50, 140, 200, 25);
		fromt.setFont(new Font("serit", Font.BOLD, 15));
		add(fromt);

		JLabel frt = new JLabel("Going To");
		frt.setBounds(50, 170, 100, 30);
		frt.setFont(new Font("serit", Font.BOLD, 15));
		add(frt);

		got = new JTextField();
		got.setBounds(50, 200, 200, 25);
		got.setFont(new Font("serit", Font.BOLD, 15));
		add(got);

		subcrh = new JButton("Submit");
		subcrh.setBounds(50, 240, 100, 30);
		subcrh.setBackground(Color.black);
		subcrh.setForeground(Color.white);
		subcrh.addActionListener(this);
		add(subcrh);

		cancrh = new JButton("Cancel");
		cancrh.setBounds(180, 240, 100, 30);
		cancrh.setBackground(Color.black);
		cancrh.setForeground(Color.white);
		cancrh.addActionListener(this);
		add(cancrh);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BusSearch b = new BusSearch();
		b.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == subcrh) {
			System.out.println("Search");
			fromtt = fromt.getText();
			goingtt = got.getText();
			Table t = new Table();
			setVisible(false);
			t.setVisible(true);
			t.BusSearchTable(fromtt, goingtt);
		} else {
			Login l = new Login();
			setVisible(false);
			l.setVisible(true);
		}
	}

}
