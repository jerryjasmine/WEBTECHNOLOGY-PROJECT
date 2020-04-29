package jdbconnection;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class login {

	private JFrame frame;
	private JTextField username;
	private JTextField password;

	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {//admin ad=new admin();
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public login() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 796, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ATHEANEUM VOTING SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD, 13));
		lblNewLabel.setBounds(272, 35, 255, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(181, 104, 123, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(194, 164, 105, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(472, 104, 142, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(472, 164, 142, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sta="";
				try
				{
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");
				try
				{
				
		           Statement st = connection.createStatement();

		           ResultSet rs;
		          
		                     rs = st.executeQuery("select status from admin");
		                     if(rs.next())
		                     {
		                    	  sta=rs.getString("status");
		                    	
		                     }
		         
		                    
			}
				catch (SQLException sq) {
            		System.out.println("SQL statement is not executed! Error is: " + sq.getMessage());
            		
		}
				
				if(sta.contentEquals("start"))
				{
				String s1=username.getText();
				String s2=password.getText();
				validate va=new validate();
				boolean b1=va.nullcheck(s1);
				boolean b2=va.nullcheck(s2);
				if(b1&&b2)
				{
				try
		   				{
		   				

		              PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select username, password,designation from users where username=? and password=?");

		                       st.setString(1,s1);
		                       st.setString(2,s2);
		                       ResultSet rs2 = st.executeQuery();
		                       if (rs2.next()) {
		                       	
		                       	String degn = (String)rs2.getString("designation");
		                       	String degn1 = (String)rs2.getString("username");
		                       	
		                       	String s3="voter";
		                       	String s4="candidate";
		                      
		                       	if(degn.contentEquals(s3))
		                       		{try
		            				{
		                				

		                		           Statement st1 = connection.createStatement();
		                		           ResultSet rs=st1.executeQuery("select status from voters where name='"+s1+"'");
		                		           if(rs.next())
		                		           {
		                		        	   String a=rs.getString("status");
		                		        	   if(a.contentEquals("completed"))
		                		        	   { 
		                		        		   JOptionPane.showMessageDialog(frame, "sorry u already voted");
		                		        	   frame.setVisible(false);
		                		        	   }
		                		        	   else
		                		        		   {JOptionPane.showMessageDialog(frame, "Welcome");
		                		        		   voterlogin vl=new voterlogin(s1);
		   		                       		vl.show(s1);
		   		                       	 frame.setVisible(false);
		                		        		   }
		                		        	   
		                		           }
		            				}
		                       		catch (SQLException sq) {
		            	        		System.out.println("SQL statement is not executed! Error is: " + sq.getMessage());
		            	        		
		            		}
		                       		
		                       		
		                       		}
		                       	else if(degn.contentEquals(s4))
		                       	{JOptionPane.showMessageDialog(frame, "Welcome");
		                       		candidatelogin cl=new candidatelogin(degn1);
		                       		cl.show(degn1);
		                       	}
		                       		
		   				} 	
		                       
		                       else
		                       {
		                       	JOptionPane.showMessageDialog(frame, "wrong username or password .dont have account signup it");
		                       
		                       }


		                      
		                      
		   				}
		                       catch (SQLException s) {
		                   		System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
		                   		
		   			}
		        		   
		        	   }
		        		   
		           
		           

		           
			
				
				
				else
					JOptionPane.showMessageDialog(frame, "enter info");
				
				}
				else
					{JOptionPane.showMessageDialog(frame, "voting has not yet started");	
					frame.setVisible(false);
					}
				
			}
				catch(Exception e)
				{System.out.println("database npt connected " + e.getMessage());}
			}
		});
		btnNewButton.setBounds(366, 213, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
         
		
		JButton btnNewButton_1 = new JButton("SIGNUP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				signup si=new signup();
				si.show();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(366, 267, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
