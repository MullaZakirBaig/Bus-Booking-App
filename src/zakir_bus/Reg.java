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

import zakir_bus_data.Reg_data;
import zakir_bus_data.SQLConnection;

public class Reg extends JFrame implements ActionListener {

	JButton sub;
	JButton can;

	JTextField usert;
	JTextField gendert;
	JTextField emailt;
	JTextField passt;
	JTextField conpasst;
	
	static String username;
	static String gender;
	static String email;
	

	public Reg() {

		// Reg_data rg = new Reg_data();
		getContentPane().setBackground(Color.white);
		setBounds(100, 100, 600, 400);
		setLayout(null);

		JLabel logn = new JLabel("Registration");
		logn.setBounds(100, 20, 150, 30);
		logn.setFont(new Font("serit", Font.BOLD, 20));
		add(logn);

		JLabel user = new JLabel("UserName");
		user.setBounds(100, 60, 100, 25);
		user.setFont(new Font("serit", Font.BOLD, 15));
		add(user);

		usert = new JTextField();
		usert.setBounds(250, 60, 200, 25);
		usert.setFont(new Font("serit", Font.BOLD, 15));
		add(usert);

		JLabel gender = new JLabel("Gender");
		gender.setBounds(100, 90, 100, 25);
		gender.setFont(new Font("serit", Font.BOLD, 15));
		add(gender);

		gendert = new JTextField();
		gendert.setBounds(250, 90, 200, 25);
		gendert.setFont(new Font("serit", Font.BOLD, 15));
		add(gendert);

		JLabel email = new JLabel("Email");
		email.setBounds(100, 120, 100, 25);
		email.setFont(new Font("serit", Font.BOLD, 15));
		add(email);

		emailt = new JTextField();
		emailt.setBounds(250, 120, 200, 25);
		emailt.setFont(new Font("serit", Font.BOLD, 15));
		add(emailt);

		JLabel pass = new JLabel("Password");
		pass.setBounds(100, 150, 100, 25);
		pass.setFont(new Font("serit", Font.BOLD, 15));
		add(pass);

		passt = new JTextField();
		passt.setBounds(250, 150, 200, 25);
		passt.setFont(new Font("serit", Font.BOLD, 15));
		add(passt);

		JLabel conpass = new JLabel("Conform Password");
		conpass.setBounds(100, 180, 140, 25);
		conpass.setFont(new Font("serit", Font.BOLD, 15));
		add(conpass);

		conpasst = new JTextField();
		conpasst.setBounds(250, 180, 200, 25);
		conpasst.setFont(new Font("serit", Font.BOLD, 15));
		add(conpasst);

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

		Reg r = new Reg();
		r.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sub) {
			System.out.println("sub");

			SQLConnection c = new SQLConnection();

			username = usert.getText();
			gender = gendert.getText();
			email = emailt.getText();
			String password = passt.getText();
			String con_password = conpasst.getText();

			if (password.equalsIgnoreCase(con_password)) {
				try {
					String Query = "INSERT INTO registerbus (UserName, Gender, Email, Password_f, Con_password) VALUES (?, ?, ?, ?, ?)";

					PreparedStatement stm = c.con.prepareStatement(Query);
					stm.setString(1, username);
					stm.setString(2, gender);
					stm.setString(3, email);
					stm.setString(4, password);
					stm.setString(5, con_password);
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
				JOptionPane.showMessageDialog(null, "password and Conform password missmatch");
			}
		} else {
			setVisible(false);
			SubClass m = new SubClass();
			m.setVisible(true);
		}

	}

}
