package zakir_bus;

import java.awt.Color;

import javax.swing.JFrame;

public class BusTable extends JFrame {
	
	public BusTable() {
		
		getContentPane().setBackground(Color.white);
		setBounds(100,100,600,400);
		setLayout(null);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BusTable tb = new BusTable();
		tb.setVisible(true);
	}

}
