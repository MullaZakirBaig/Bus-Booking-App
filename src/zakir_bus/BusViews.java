package zakir_bus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import zakir_bus_data.SQLConnection;

public class BusViews<DefaultModelTable> extends JFrame implements ActionListener {

	private JTable table;
	private JButton subcrh;
	private JButton cancrh;
	private JTextField deletet;
	private JLabel label;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusViews frame = new BusViews();
					frame.setVisible(true);
					frame.Busview();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BusViews() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		getContentPane().setBackground(Color.white);
		getContentPane().setLayout(new FlowLayout()); // Use a layout manager

		// Panel for the table
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setBackground(Color.white);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Bus Name", "Fromto", "Goingto", "Price", "Date & Time" }));

		// Use a JScrollPane to handle scrolling
		scrollPane.setViewportView(table);
		scrollPane.setPreferredSize(new Dimension(500, 250));

		// Panel for text field and label
		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new FlowLayout());

		label = new JLabel("Enter Delete Bus ID :");
		textFieldPanel.add(label);

		deletet = new JTextField(5); // 20 columns
		textFieldPanel.add(deletet);
		// textFieldPanel.setPreferredSize(new Dimension(100, 0));

		getContentPane().add(textFieldPanel);

		// Panel for buttons with FlowLayout
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		subcrh = new JButton("Delete");
		subcrh.setBackground(Color.black);
		subcrh.setForeground(Color.white);
		subcrh.addActionListener(this);
		buttonPanel.add(subcrh);

		cancrh = new JButton("Cancel");
		cancrh.setBackground(Color.black);
		cancrh.setForeground(Color.white);
		cancrh.addActionListener(this);
		buttonPanel.add(cancrh);

		// Add the button panel to the content pane
		getContentPane().add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == subcrh) {
			System.out.println("Delete");
			// ---------------------------
			String dt = deletet.getText();
			int did = Integer.parseInt(dt);

			try {
				SQLConnection c = new SQLConnection();
				String Query = "Delete from bustable where id = '" + did + "'";
				PreparedStatement stm = c.con.prepareStatement(Query);
				int res = stm.executeUpdate();
				if (res > 0) {
					JOptionPane.showMessageDialog(null, "Delete to Bus Details");
				} else {
					JOptionPane.showMessageDialog(null, "Not Deleted bus Details");
				}
			} catch (Exception j) {
				j.printStackTrace();
			}
			// ----------------------

		} else {
			System.out.println("cancel");
			Admin a = new Admin();
			setVisible(false);
			a.setVisible(true);

		}

	}

	public void Busview() {
		try {
			SQLConnection c = new SQLConnection();
			String Query = "Select * from bustable";
			PreparedStatement stm = c.con.prepareStatement(Query);
			ResultSet res = stm.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			// model.setRowCount(0);
			while (res.next()) {
				Object[] data = { res.getInt("Id"), res.getString("BusName"), res.getString("Fromto"),
						res.getString("Goingto"), res.getString("Price"), res.getString("Dates_times") };
				model.addRow(data);
			}
			if (model.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "No Data In Table");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void RegDetails() {
		try {
			SQLConnection c = new SQLConnection();
			String Query = "Select * from registerbus";
			PreparedStatement stm = c.con.prepareStatement(Query);
			ResultSet res = stm.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			// model.setRowCount(0);
			while (res.next()) {
				Object[] data = { res.getInt("UserName"), res.getString("Gender"), res.getString("Email"),
						res.getString("Password_f"), res.getString("Con_password") };
				model.addRow(data);
			}
			if (model.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "No Data In Table");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
