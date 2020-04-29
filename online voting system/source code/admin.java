package jdbconnection;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class admin {
private JFrame frame;
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public admin() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rd1 = new JRadioButton("Start");
		rd1.setBounds(89, 113, 109, 23);
		frame.getContentPane().add(rd1);
		
		JRadioButton rd2 = new JRadioButton("Stop");
		rd2.setSelected(true);
		rd2.setBounds(89, 139, 109, 23);
		frame.getContentPane().add(rd2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rd1);
		bg.add(rd2);
		
		JLabel lblNewLabel = new JLabel("Admin functions");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(51, 30, 303, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Start voting system?");
		lblNewLabel_1.setBounds(39, 75, 117, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    try
	{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

			Statement st = connection.createStatement();

			int rs;
			     if(rd1.isSelected())
			          { rs = st.executeUpdate("update admin set status='start'");
			          JOptionPane.showMessageDialog(frame, "Voting system has started.....");
			          }
			          else
			        	   rs=st.executeUpdate("update admin set status='stop'");
			                    
				}
					catch (SQLException sq) {
	            		System.out.println("SQL statement is not executed! Error is: " + sq.getMessage());
	            		
			}
				
				frame.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(137, 191, 89, 23);
		frame.getContentPane().add(btnNewButton);
			JButton btnNewButton_1 = new JButton("Issue result");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String ,Integer> map=new HashMap<String,Integer>();  String can;int temp;
				try
				{
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

		           Statement st = connection.createStatement();
		           ResultSet rs=st.executeQuery("select * from voteslist");
		           while(rs.next())
		           {temp=rs.getInt("votes");
		        	  can=rs.getString("candidate");
		        	  map.put(can,temp);
		        	  
		           }

		           
			}
				catch (SQLException sq) {
            		System.out.println("SQL statement is not executed! Error is: " + sq.getMessage());
            		
		}
				List<Map.Entry<String, Integer> > list = 
			               new LinkedList<Map.Entry<String, Integer> >(map.entrySet()); 
			  
			        // Sort the list 
			        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
			            public int compare(Map.Entry<String, Integer> o1,  
			                               Map.Entry<String, Integer> o2) 
			            { 
			                return (o2.getValue()).compareTo(o1.getValue()); 
			            } 
			        }); 
			          
			        // put data from sorted list to hashmap  
			        HashMap<String, Integer> temp1 = new LinkedHashMap<String, Integer>(); 
			        for (Map.Entry<String, Integer> aa : list) { 
			            temp1.put(aa.getKey(), aa.getValue());
			        }
			        System.out.println("candidate\tvotes");
			            for (Map.Entry<String, Integer> en :temp1.entrySet()) { 
			                System.out.println(en.getKey()+"\t"+ en.getValue()); 
			            }
			            String value = temp1.entrySet().stream().findFirst().get().getKey();
				System.out.println("Winner: " + value);
				
			}
			
		});
		btnNewButton_1.setBounds(290, 212, 134, 23);
		frame.getContentPane().add(btnNewButton_1);
		
	
		
	}
}
