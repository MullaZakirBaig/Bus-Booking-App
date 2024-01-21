package zakir_bus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class MainClass extends JFrame {
	

	JProgressBar pb;
	boolean s=true;

	public MainClass(){
		getContentPane().setBackground(Color.white);
		setBounds(100,100,600,400);
		setLayout(null);
		
		ImageIcon img = new ImageIcon("C:\\Users\\HUSSAIN\\eclipse-workspace\\Bus_Booking_App\\src\\Images/bus_images.jpg");
		JLabel imgm = new JLabel(img);
		imgm.setBounds(125, 5, 350, 300);
		add(imgm);
		
		JLabel m = new JLabel("ZAKIR BUS");
		m.setBounds(180, 250, 250,30);
		m.setForeground(Color.black);
		m.setFont(new Font("serit",Font.BOLD,40));
		add(m);
		
		pb = new JProgressBar(0,2000);
		pb.setBounds(-1, 355, 600, 15);
		pb.setForeground(Color.black);
		pb.setValue(0);    
		pb.setStringPainted(true);    
		add(pb);    
		//setSize(250,150);  
		
	}
	public void iterate(){  
		int i=0;
	
		while(i<=2000){    
		  pb.setValue(i);    
		  i=i+20;    
		  try{Thread.sleep(150);}catch(Exception e) {
			  e.printStackTrace();
		  }
		}
	}
		   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainClass t = new MainClass();
		t.setVisible(true);
		t.iterate();
		SubClass mc = new SubClass();
		t.setVisible(false);
		mc.setVisible(true);
	}

}
