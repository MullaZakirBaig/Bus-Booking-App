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

public class Table extends JFrame implements ActionListener{

    private JTable table;
    private JButton subcrh;
    private JButton cancrh;
    private JTextField textField;
    private JLabel label;
    
    //public static int I;
    static String BS;
    static String PR;
    static String DT;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Table frame = new Table();
                    frame.setVisible(true);
                    frame.BusSearchTable(BusSearch.fromtt, BusSearch.goingtt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Table() {
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
                new String[] { "Id", "Bus Name", "Price", "Date & Time" }
        ));

        // Use a JScrollPane to handle scrolling
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new Dimension(500, 250));

        // Panel for text field and label
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new FlowLayout());

        label = new JLabel("Enter the Bus ID :");
        textFieldPanel.add(label);

        textField = new JTextField(5); // 20 columns
        textFieldPanel.add(textField);
      //  textFieldPanel.setPreferredSize(new Dimension(100, 0));

        getContentPane().add(textFieldPanel);

        // Panel for buttons with FlowLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        subcrh = new JButton("Submit");
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
		if(e.getSource()==subcrh) {
			System.out.println("sub");
			NewSeat s = new NewSeat(5,5);
			setVisible(false);
			s.setVisible(true);
		}else {
			System.out.println("cancel");
			setVisible(false);
			BusSearch bs = new BusSearch();
			bs.setVisible(true);
		}
	}
	
	public void BusSearchTable(String fromtt, String goingtt) {
		try {
			SQLConnection c = new SQLConnection();
			String Query = "Select * from bustable where Fromto = '"+fromtt+"' and Goingto = '"+goingtt+"'";
			PreparedStatement stm =c.con.prepareStatement(Query);
			ResultSet res = stm.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			// model.setRowCount(0);
			while (res.next()) {
				BS=res.getString("BusName");
				PR=res.getString("Price");
				DT=res.getString("Dates_times");
				Object[] data = { res.getInt("Id"), BS, PR, DT };
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
