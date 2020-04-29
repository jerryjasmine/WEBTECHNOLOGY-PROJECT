package jdbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

import javax.swing.JOptionPane;

public class validate {

	public boolean nullcheck(String a) {
		// TODO Auto-generated method stub
if(!a.isEmpty())
	return true;
return false;
	}
	public boolean isexistschecku(String a) {
		// TODO Auto-generated method stub
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

	           Statement st1 = connection.createStatement();
	           ResultSet rs=st1.executeQuery("select username from users where username='"+a+"'");
	           if(rs.next())
	           {
	        	   String a1=rs.getString("username");
	        	   while(a.contentEquals(a1))
	        	   { //System.out.println("username taken");
	        		   //JOptionPane.showMessageDialog(frame, "sorry u already voted");
	        	  // frame.setVisible(false);
	        		   return true;
	        	   }
	        	  
	        	   
	           }
		}
   		catch (SQLException sq) {
    		System.out.println("SQL statement is not executed! Error is: " + sq.getMessage());
    		
}
		return false;
	}
	
	public boolean isdigitcheck(String a)
	{
		int k=0,flag=1;boolean k1=true;
		while(k<a.length())
			{k1=Character.isDigit(a.charAt(k++));
			}
		return k1;
	}
		
}
	
	


