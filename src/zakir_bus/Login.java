package zakir_bus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import zakir_bus_data.SQLConnection;

public class Login extends JFrame implements ActionListener {
	
	JButton sub;
	JButton can;
	
	JTextField usert;
	JTextField passt;
	
	static String username;

	public Login() {
		
		getContentPane().setBackground(Color.white);
		setBounds(100,100,600,400);
		setLayout(null);
		
		JLabel logn = new JLabel("Login :");
		logn.setBounds(100, 50, 100, 30);
		logn.setFont(new Font("serit",Font.BOLD,20));
		add(logn);
		
		JLabel user = new JLabel("UserName");
		user.setBounds(100, 100, 100, 30);
		user.setFont(new Font("serit",Font.BOLD,15));
		add(user);
		
		usert = new JTextField();
		usert.setBounds(100, 130, 200, 25);
		usert.setFont(new Font("serit",Font.BOLD,15));
		add(usert);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(100, 150, 100, 30);
		pass.setFont(new Font("serit",Font.BOLD,15));
		add(pass);
		
		passt = new JTextField();
		passt.setBounds(100, 180, 200, 25);
		passt.setFont(new Font("serit",Font.BOLD,15));
		add(passt);
		
		sub = new JButton("Submit");
		sub.setBounds(100, 240, 100, 30);
		sub.setBackground(Color.black);
		sub.setForeground(Color.white);
		sub.addActionListener(this);
		add(sub);
		
		can = new JButton("Cancel");
		can.setBounds(230, 240, 100, 30);
		can.setBackground(Color.black);
		can.setForeground(Color.white);
		can.addActionListener(this);
		add(can);
		
		ImageIcon img = new ImageIcon("C:\\Users\\HUSSAIN\\eclipse-workspace\\Bus_Booking_App\\src\\Images/log_pic_1.png");
		Image i = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(i);
		JLabel imgm = new JLabel(img2);
		imgm.setBounds(350, 60, 150, 150);
		add(imgm);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == sub) {
			System.out.println("sub");
	//----------------------	
			SQLConnection c = new SQLConnection();
			username = usert.getText();
			String password = passt.getText();
			try {
				String Query = "Select * from registerbus where Username = '"+username+"' and Password_f = '"+password+"'";
				PreparedStatement stm =c.con.prepareStatement(Query);
				ResultSet res = stm.executeQuery();
				if(res.next()) {
					BusSearch bs = new BusSearch();
					setVisible(false);
					bs.setVisible(true);
					Reg_Table rt = new Reg_Table();
					rt.Reg_ticket();
				}else {
					JOptionPane.showMessageDialog(null, "User & Password Incoorect please try again");
				}
			}catch(SQLException j) {
				j.printStackTrace();
			}
			
			
//-------------------
			
		}else {
			SubClass m = new SubClass();
			setVisible(false);
			m.setVisible(true);
			System.out.println("cancel");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Login l =new Login();
		l.setVisible(true);
	}

}
