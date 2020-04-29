package jdbconnection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;
public class candidatelogin {

	private JFrame frame;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public void show (String a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					candidatelogin window = new candidatelogin(a);
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
	public candidatelogin(String a) {
		initialize(a);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String a) {
		frame = new JFrame();
		frame.setBounds(100, 100, 687, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String b=a;
		JTextPane textPane = new JTextPane();
		textPane.setBounds(238, 120, 219, 177);
		frame.getContentPane().add(textPane);
		//textPane.setText(a+" = "+degn1);
		JButton btnNewButton = new JButton("CLICK TO SEE YOUR VOTES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

           Statement st = connection.createStatement();

                  //  st.setString(1,s1);
                   // st.setString(2, s2);
                    ResultSet rs = st.executeQuery("Select votes from voteslist where candidate='"+a+"' ");
                    if(rs.next())
		
                    {
                    	//JOptionPane.showMessageDialog(frame, "Welcome");
                    String degn1 = rs.getString("votes");
                  //  String degn2= rs.getString("votes");
                   // System.out.println(degn1);
                    textPane.setText(a+" = "+degn1+" votes\n");
                    	//cb.addItem(degn1);
                    } 	
                    
				}
				catch (SQLException s) {
            		System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
            		
		}
				//frame.setVisible(false);
			}
			
		}
		);
		btnNewButton.setBounds(234, 31, 223, 23);
		frame.getContentPane().add(btnNewButton);
		
		table_2 = new JTable();
		table_2.setBounds(122, 235, 154, -102);
		frame.getContentPane().add(table_2);
		
		
	}
}
