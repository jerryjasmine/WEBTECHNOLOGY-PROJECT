package jdbconnection;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;

public class voterlogin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void show(String a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					voterlogin window = new voterlogin(a);
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
	public voterlogin(String a) {
		initialize(a);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VOTER PORTAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(249, 26, 195, 41);
		frame.getContentPane().add(lblNewLabel);
		
		//JButton btnNewButton = new JButton("click here for candidates");
		JComboBox cb = new JComboBox();
		cb.setBounds(267, 123, 217, 22);
		frame.getContentPane().add(cb);
		cb.addItem("select a candidate");
		//btnNewButton.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent arg0) {
				
            	
				/*JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setBounds(21, 129, 147, 29);
				frame.getContentPane().add(lblNewLabel_1);*/
				
				/*JLabel cl1= new JLabel("candidates");
			cl1.setBounds(39, 114, 75, 14);
				frame.getContentPane().add(cl1);
				cl1.setVisible(true);*/
				try
				{
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

           Statement st = connection.createStatement();

                  //  st.setString(1,s1);
                   // st.setString(2, s2);
                    ResultSet rs = st.executeQuery("Select username from users where designation='candidate'");
                    while (rs.next()) {
                    	//JOptionPane.showMessageDialog(frame, "Welcome");
                    	String degn1 = rs.getString("username");
                    	//System.out.println(degn1);
                    	cb.addItem(degn1);
                    	
                    }
				}
				catch (SQLException s) {
            		System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
            		
		}
			
	
		//btnNewButton.setBounds(77, 63, 230, 23);
		//frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=(String)cb.getSelectedItem();
				int val=0;
				if(a.equals("select a candidate"))
					JOptionPane.showMessageDialog(frame,"pls select a candidate");
				else
				{	
				try
				{
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

		           Statement st = connection.createStatement();

		                  //  st.setString(1,s1);
		                   // st.setString(2, s2);
		                    ResultSet rs = st.executeQuery("select votes from voteslist where candidate ='"+a+"'");
			if(rs.next())
			{
				 val=rs.getInt("votes");
				 //System.out.println(val);
				 val=++val;
				// System.out.println(val);
			}
			
			 
				}
				catch (SQLException s) {
            		System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
            		
		}
				try
				{
				Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

		          // Statement st = connection.createStatement();
		           Statement st1 = connection1.createStatement();
					int rs1=st1.executeUpdate("update voteslist set votes='"+val+"' where candidate='"+a+"'");
				}
				catch (SQLException s) {
            		System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
            		
		}
				try
				{
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

		           Statement st1 = connection.createStatement();
		           int rs=st1.executeUpdate("update voters set status='completed' where name='"+user+"'");
		           

		           
			}
				catch (SQLException sq) {
	        		System.out.println("SQL statement is not executed! Error is: " + sq.getMessage());
	        		
		}
				frame.setVisible(false);
			}
			}
			
			
		});
		btnNewButton_1.setBounds(324, 219, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
		
	}
}
