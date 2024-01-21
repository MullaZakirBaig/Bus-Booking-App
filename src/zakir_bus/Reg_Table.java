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
import javax.swing.table.DefaultTableModel;

import zakir_bus_data.SQLConnection;

public class Reg_Table extends JFrame implements ActionListener{

    private JTable table;
    private JButton subcrh;
    private JButton bck;
    private JTextField textField;
    private JLabel label;
    
    //public static int I;
    static String userN;
    static String Gender;
    static String Email;
    static String Password;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reg_Table frame = new Reg_Table();
                    frame.setVisible(true);
                   frame.Reg_SearchTable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Reg_Table() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        getContentPane().setBackground(Color.white);
        getContentPane().setLayout(new FlowLayout()); // Use a layout manager

        // Panel for the table
        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(Color.white);
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "UserName", "Gender", "Email", "Password" }
        ));

        // Use a JScrollPane to handle scrolling
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new Dimension(500, 250));

        // Panel for text field and label
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new FlowLayout());

       
        getContentPane().add(textFieldPanel);

        // Panel for buttons with FlowLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

       
        bck = new JButton("Back");
        bck.setBackground(Color.black);
        bck.setForeground(Color.white);
        bck.addActionListener(this);
        buttonPanel.add(bck);

        // Add the button panel to the content pane
        getContentPane().add(buttonPanel);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Admin a = new Admin();
		setVisible(false);
		a.setVisible(true);
	}
	
	public void Reg_SearchTable() {
		try {
			SQLConnection c = new SQLConnection();
			String Query = "Select * from registerbus";
			PreparedStatement stm =c.con.prepareStatement(Query);
			ResultSet res = stm.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			// model.setRowCount(0);
			while (res.next()) {
				
				userN=res.getString(1);
				Gender=res.getString(2);
				Email=res.getString(3);
				Password = res.getString(4);
				Object[] data = { userN, Gender, Email, Password };
				model.addRow(data);
			}
			if (model.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "No Data In Table");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Reg_ticket() {
		try {
			SQLConnection c = new SQLConnection();
			String Query = "Select * from registerbus where UserName = '"+Login.username+"'";
			PreparedStatement stm =c.con.prepareStatement(Query);
			ResultSet res = stm.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			// model.setRowCount(0);
			while (res.next()) {
				
				userN=res.getString(1);
				Gender=res.getString(2);
				Email=res.getString(3);
				Password = res.getString(4);
				Object[] data = { userN, Gender, Email, Password };
				model.addRow(data);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
