package jdbconnection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Font;
public class candidate {

	private JFrame frame;
	private JTextField tfr;

	/**
	 * Launch the application.
	 */
	public void show(String a1) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					candidate window = new candidate(a1);
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

	public candidate(String a1) {
		initialize(a1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String a1) {
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANDIDATE DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(243, 13, 309, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DEPT");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(243, 100, 86, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblRegno = new JLabel("REGNO");
		lblRegno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegno.setBounds(254, 157, 86, 26);
		frame.getContentPane().add(lblRegno);
		
		JComboBox tfd = new JComboBox();
		tfd.setBounds(502, 102, 117, 22);
		frame.getContentPane().add(tfd);
		tfd.addItem("IT");
		tfd.addItem("CSE");
		tfd.addItem("ECE");
		tfd.addItem("EI");
		tfd.addItem("AERO");
		tfd.addItem("AUTO");
		tfd.addItem("RPT");
		tfd.addItem("PT");
		
		tfr = new JTextField();
		tfr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		}});
		tfr.setBounds(508, 160, 86, 20);
		
		
			
		frame.getContentPane().add(tfr);
		tfr.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              // String n=tfr.getText();
String s1=(String)tfd.getSelectedItem();
				String s=tfr.getText();
				validate va=new validate();
				if(va.nullcheck(s))
				{
					
							if(!va.isdigitcheck(s))
								{JOptionPane.showMessageDialog(frame,"regno should be nos");
								
								}
				//frame.getContentPane().add(btnNewButtonlog(null, "regno should be numbers");
							//frame.setVisible(false);
							else
							{database db=new database();
							db.show2(s,s1,"student",a1);
							int j=0;
							try
							{
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

					           Statement st = connection.createStatement();
//ResultSet rs1=st.executeQuery("select )
					                  //  st.setString(1,s1);
					                   // st.setString(2, s2);
					          
					                    int rs = st.executeUpdate("insert voteslist values('"+a1+"','"+j+"')");
					                    //System.out.println(rs);
					                    frame.setVisible(false);
						}
							catch (SQLException sq) {
			            		System.out.println("SQL statement is not executed! Error is: " + sq.getMessage());
			            		
					}
							}
							
							
			}
				
			
			else
				JOptionPane.showMessageDialog(frame,"enter info");
			}
		}
		);
		submit.setBounds(344, 263, 89, 23);
	//frame.getContentPane().add(btnNewButtonlog(null, "regno should be numbers");
					
				
				
		frame.getContentPane().add(submit);
		
		
		//REGNO.setBounds(191, 103, 86, 20);
		
		
			
		//frame.getContentPane().add(REGNO);
		//REGNO.setColumns(10);
	}
}
