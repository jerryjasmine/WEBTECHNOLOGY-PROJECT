package jdbconnection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.Font;

public class signup {

	private JFrame frame;
	private JTextField tfl;
	private JTextField tfp;
	private JTextField tfa;
	private JTextField tff;
	private JTextField tfu;
	private JPasswordField tfp1;

	/**
	 * Launch the application.
	 */
	public  void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
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
	public signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGNUP FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(303, 8, 172, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FIRSTNAME");
		lblNewLabel_1.setBounds(338, 96, 87, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("LASTNAME");
		lblPassword.setBounds(338, 147, 87, 22);
		frame.getContentPane().add(lblPassword);
		
		JLabel passs = new JLabel("PASSWORD");
		passs.setBounds(21, 203, 87, 22);
		frame.getContentPane().add(passs);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setBounds(338, 191, 87, 22);
		frame.getContentPane().add(lblAge);
		
		tfl = new JTextField();
		tfl.setBounds(523, 148, 139, 20);
		frame.getContentPane().add(tfl);
		tfl.setColumns(10);
		
		tfp = new JPasswordField();
		tfp.setColumns(10);
		tfp.setBounds(118, 204, 139, 20);
	
		frame.getContentPane().add(tfp);
		
		tfa = new JTextField();
		tfa.setColumns(10);
		tfa.setBounds(523, 192, 139, 20);
		frame.getContentPane().add(tfa);
		
		tff = new JTextField();
		tff.setColumns(10);
		tff.setBounds(523, 97, 139, 20);
		frame.getContentPane().add(tff);
		
		JLabel users = new JLabel("USERNAME");
		users.setBounds(21, 148, 87, 20);
		frame.getContentPane().add(users);
tfp1 = new JPasswordField();
		
		
		tfp1.setBounds(118, 245, 139, 20);
		frame.getContentPane().add(tfp1);
		
		tfu = new JTextField();
		tfu.setText("");
		tfu.setBounds(116, 148, 139, 20);
		frame.getContentPane().add(tfu);
		tfu.setColumns(10);
		JComboBox dn = new JComboBox();
		dn.addItem("voter");
		dn.addItem("candidate");
		dn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			
				
			}
		});
		dn.setBounds(523, 237, 139, 22);
		frame.getContentPane().add(dn);

		
		JButton btnNewButton = new JButton("SIGNUP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n1=tff.getText();
				String n2=tfu.getText();
				String n3=tfp.getText();@SuppressWarnings("deprecation")
				String n4=tfp1.getText();
				String n5=tfa.getText();
				String n6=tfl.getText();
				database db=new database();
				validate va=new validate();
				boolean bo=((va.nullcheck(n1))&&(va.nullcheck(n2))&&(va.nullcheck(n3))&&(va.nullcheck(n4))&&(va.nullcheck(n5))&&(va.nullcheck(n6)));
				if(bo)
				{int flag=0;
					if(va.isexistschecku(n2))
					{JOptionPane.showMessageDialog(frame, "username taken");
				//String a2=tfp.getText();
					flag=1;
					}
					
					if((!n2.matches("[a-zA-Z0-9]+"))|| n2.length()<8)
					{
						JOptionPane.showMessageDialog(frame, "username should contain 1 uppercase one lowercase and a digit of length 8");
						flag=1;
					}
					if((!n3.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})")))
					{
						JOptionPane.showMessageDialog(frame, "password should contain 1 uppercase one lowercase and any one special chararcter and a digit of length 8");
						flag=1;
					}
					
				//String b1=tfp1.getText();
				if(!n3.equals(n4))
					{JOptionPane.showMessageDialog(frame, "password not matches");
					flag=1;
					}
				
				
				/*else if(va.isexistscheckp(n3))
					{JOptionPane.showMessageDialog(frame, "password taken");flag=1;}*/
					
				String s=tfa.getText();
				boolean k1=va.isdigitcheck(s);
				if(k1==false)
					JOptionPane.showMessageDialog(frame, "age should be numbers");
					if (k1==true)
					{int a1=Integer.parseInt(s);
					//System.out.println(a1);
						if(a1<18 || a1>100)
					      JOptionPane.showMessageDialog(frame, " age is less than 18");
						else if(flag==0)
						{/*if(va.isexistscheck(n3))
							JOptionPane.showMessageDialog(frame, "password taken");
					String s=REGNO.getText();
				int k=0;boolean k1=true;
				while(k<s.length())
					k1=Character.isDigit(s.charAt(k++));
				if(k1==false)
					JOptionPane.showMessageDialog(frame, "regno should be numbers");*/
				
				//String s1=tfu.getText();
				//String s2=tfp.getText();
				String s3=(String)dn.getSelectedItem();
				db.show(n2,n3,s3);
				//String s3=(String)cb.getSelectedItem();
				if(s3=="candidate")
				{candidate c=new candidate(n2);
				c.show(n2);
				}
				else if(s3=="voter")
					{voter v=new voter(n2);
				v.show(n2);
					}
				db.show1(n2,n3,n1,n6,n5,s3);
				frame.setVisible(false);
				}
			}
				}
				else
					JOptionPane.showMessageDialog(frame,"enter info");
			}
		});
		btnNewButton.setBounds(338, 367, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("designation");
		lblNewLabel_2.setBounds(338, 245, 81, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password");
		lblNewLabel_3.setBounds(10, 236, 98, 46);
		frame.getContentPane().add(lblNewLabel_3);
		
		/*JComboBox cb = new JComboBox();
		cb.addItem("voter");
		cb.addItem("candidate");
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*cb.addItem("voter");
				cb.addItem("candidate");
				
			}
		});
		cb.setBounds(333, 220, 81, 22);
		frame.getContentPane().add(cb);*/
	}
}
