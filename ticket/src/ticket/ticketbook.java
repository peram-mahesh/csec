package ticket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ticketbook {

	private JFrame frame;
	private JTextField n;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticketbook window = new ticketbook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ticketbook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 777, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ticket booking system");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(207, 11, 401, 60);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 144, 150, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		n = new JTextField();
		n.setBounds(160, 158, 138, 20);
		frame.getContentPane().add(n);
		n.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("from");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 190, 87, 34);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox f1 = new JComboBox();
		f1.setModel(new DefaultComboBoxModel(new String[] {"hyderabad", "nalgonda", "suryapet ", "khammam", "sirisilla"}));
		f1.setBounds(160, 196, 138, 30);
		frame.getContentPane().add(f1);
		
		JLabel lblNewLabel_3 = new JLabel("to");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 259, 63, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox t = new JComboBox();
		t.setModel(new DefaultComboBoxModel(new String[] {"nalgonda", "hyderabad", "suryapet", "khammam", "bng", "ygt"}));
		t.setBounds(160, 267, 138, 22);
		frame.getContentPane().add(t);
		
		JLabel lblNewLabel_4 = new JLabel("no of tickets");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 323, 115, 34);
		frame.getContentPane().add(lblNewLabel_4);
		
		JComboBox n1 = new JComboBox();
		n1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		n1.setBounds(160, 333, 138, 22);
		frame.getContentPane().add(n1);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=n.getText();
				String from= (String) f1.getSelectedItem();
				String to=(String) t.getSelectedItem();
				String noof=(String) n1.getSelectedItem();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mrec","root","welcome@123");
					String q="insert into ticket values('"+name+"','"+from+"','"+to+"','"+noof+"')";
					Statement st=con.createStatement();
					st.executeUpdate(q);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(btnNewButton, "done");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(136, 405, 115, 41);
		frame.getContentPane().add(btnNewButton);
	}
}
