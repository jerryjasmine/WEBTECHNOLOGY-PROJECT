package jdbconnection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class voter {

	private JFrame frame;
	private JTextField tfr;

	/**
	 * Launch the application.
	 */
	public void show(String a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					voter window = new voter(a);
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
	public voter(String a) {
		initialize(a);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String a) {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel vdetails = new JLabel("VOTER DETAILS");
		vdetails.setFont(new Font("Tahoma", Font.PLAIN, 17));
		vdetails.setHorizontalAlignment(SwingConstants.CENTER);
		vdetails.setBounds(242, 24, 309, 26);
		frame.getContentPane().add(vdetails);
		
		JLabel label = new JLabel("DEPT");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(212, 155, 86, 26);
		frame.getContentPane().add(label);
		
		JComboBox tfd = new JComboBox();
		tfd.setBounds(456, 157, 117, 22);
		frame.getContentPane().add(tfd);
		tfd.addItem("IT");
		tfd.addItem("CSE");
		tfd.addItem("ECE");
		tfd.addItem("EI");
		tfd.addItem("AERO");
		tfd.addItem("AUTO");
		tfd.addItem("RPT");
		tfd.addItem("PT");
		
		JComboBox tfc = new JComboBox();
		tfc.setBounds(456, 82, 117, 22);
		frame.getContentPane().add(tfc);
		tfc.addItem("student");
		tfc.addItem("teacher");
		JLabel lblRegnoifTeacherEnter = new JLabel("REGNO(if teacher enter ur ID number)");
		lblRegnoifTeacherEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegnoifTeacherEnter.setBounds(79, 227, 219, 26);
		frame.getContentPane().add(lblRegnoifTeacherEnter);
		
		tfr = new JTextField();
		tfr.setColumns(10);
		tfr.setBounds(456, 230, 117, 20);
		frame.getContentPane().add(tfr);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1=(String)tfd.getSelectedItem();
				String s2=(String)tfc.getSelectedItem();
				String s=tfr.getText();
				//String s=tfr.getText();
				validate va=new validate();
				if(va.nullcheck(s))
				{
					if(!va.isdigitcheck(s))
			            JOptionPane.showMessageDialog(frame,"regno should be nos");
					else
						{database db=new database();
						db.show2(s, s1,s2,a);
						frame.setVisible(false);
						
						}
							
			}
				else
					JOptionPane.showMessageDialog(frame,"enter info");
			}
		});
		button.setBounds(297, 313, 89, 23);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("CHOOSE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(223, 80, 67, 26);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	}
}
