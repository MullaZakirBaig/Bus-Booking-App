package zakir_bus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Admin extends JFrame implements ActionListener {

	JButton BusView;
	JButton BusAdd;
	JButton canc;
	JButton Unsel;
	JButton reg;

	public Admin() {
		setBounds(100, 100, 600, 400);
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel maintitle = new JLabel("Administration");
		maintitle.setBounds(150, 50, 350, 30);
		maintitle.setFont(new Font("serit", Font.BOLD, 40));
		maintitle.setForeground(Color.black);
		add(maintitle);

		ImageIcon img = new ImageIcon("C:\\Users\\HUSSAIN\\eclipse-workspace\\Bus_Booking_App\\src\\Images/admin_pic.png");
		Image i = img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(i);
		JLabel imgm = new JLabel(img2);
		imgm.setBounds(210, 90, 180, 180);
		add(imgm);

		BusView = new JButton("BusView");
		BusView.setBounds(80, 250, 100, 30);
		BusView.setBackground(Color.black);
		BusView.setForeground(Color.white);
		BusView.addActionListener(this);
		add(BusView);

		BusAdd = new JButton("BusAdd");
		BusAdd.setBounds(240, 250, 100, 30);
		BusAdd.setBackground(Color.black);
		BusAdd.setForeground(Color.white);
		BusAdd.addActionListener(this);
		add(BusAdd);

		canc = new JButton("Cancel");
		canc.setBounds(400, 250, 100, 30);
		canc.setBackground(Color.black);
		canc.setForeground(Color.white);
		canc.addActionListener(this);
		add(canc);
		
		Unsel = new JButton("UnSel-Seat");
		Unsel.setBounds(320, 300, 120, 30);
		Unsel.setBackground(Color.black);
		Unsel.setForeground(Color.white);
		Unsel.addActionListener(this);
		add(Unsel);
		
		reg = new JButton("Reg-Details");
		reg.setBounds(150, 300, 120, 30);
		reg.setBackground(Color.black);
		reg.setForeground(Color.white);
		reg.addActionListener(this);
		add(reg);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Admin a = new Admin();
		a.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == BusView) {
			System.out.println("busview");
			BusViews bv = new BusViews();
			setVisible(false);
			bv.setVisible(true);
			bv.Busview();
		} else if (e.getSource() == BusAdd) {
			System.out.println("BusAdd");
			BusAdd ba = new BusAdd();
			setVisible(false);
			ba.setVisible(true);
		}else if(e.getSource() == Unsel) {
			NewSeat.Usel_sea();	
		}else if(e.getSource()==reg) {
			Reg_Table rt = new Reg_Table();
			setVisible(false);
			rt.setVisible(true);
			rt.Reg_SearchTable();
		}
		else {
			System.out.println("cancel");
			SubClass m = new SubClass();
			setVisible(false);
			m.setVisible(true);
		}
	}

}
