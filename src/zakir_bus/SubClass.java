package zakir_bus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SubClass extends JFrame implements ActionListener {
	
	JButton Register;
	JButton login;
	JButton admin;
	
	public SubClass() {
		getContentPane().setBackground(Color.white);
		setBounds(100,100,600,400);
		setLayout(null);
		
		ImageIcon img = new ImageIcon("C:\\\\Users\\\\HUSSAIN\\\\eclipse-workspace\\\\Bus_Booking_App\\\\src\\\\Images/bus_images.jpg");
		JLabel imgm = new JLabel(img);
		imgm.setBounds(125, 5, 350, 300);
		add(imgm);
		
		/*JLabel m = new JLabel("ZAKIR BUS");
		m.setBounds(180, 220, 250,30);
		m.setForeground(Color.black);
		m.setFont(new Font("serit",Font.BOLD,40));
		add(m);*/
		
		
		Register = new JButton("Registeration");
		Register.setBounds(100, 290, 120, 30);
		Register.setBackground(Color.black);
		Register.setForeground(Color.white);
		Register.addActionListener(this);
		add(Register);
		
		login = new JButton("Login");
		login.setBounds(240, 290, 120, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		admin = new JButton("Admin");
		admin.setBounds(380, 290, 120, 30);
		admin.setBackground(Color.black);
		admin.setForeground(Color.white);
		admin.addActionListener(this);
		add(admin);
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SubClass m = new SubClass();
		m.setVisible(true);
	}
   
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == Register) {
			System.out.println("reg");
			Reg r = new Reg();
			setVisible(false);
			r.setVisible(true);
		}else if(e.getSource() == login){
			
			Login l = new Login();
			setVisible(false);
			l.setVisible(true);
			System.out.println("Login");
		}else {
			System.out.println("admin");
			Admin a = new Admin();
			setVisible(false);
			a.setVisible(true);
		}
	}
	
	
}
