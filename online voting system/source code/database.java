
package jdbconnection;
import java.sql.*;

import java.sql.*;

public class database{
public  void show(String a,String b,String c) {
	
	//System.out.println("Inserting values in Mysql database table!");
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/";
	String db = "voting";
	String driver = "com.mysql.jdbc.Driver";
	try {
	Class.forName(driver);
	con = DriverManager.getConnection(url + db, "root", "");
	try {
		Statement st = con.createStatement();
		String sql = "INSERT users VALUES('" +a+ "', '"+b+"','"+c+"')";
		//System.out.println(sql);
		int val = st.executeUpdate(sql);
		
		//System.out.println(c=="voter");
		
		if(c=="voter")
		{
			try
			{
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

	           Statement st1 = con.createStatement();
	           int rs=st1.executeUpdate("insert voters values('"+a+"','notcompleted')");
	           
	          // System.out.println("1 row affected");
	           
		}
			catch (SQLException sq) {
        		System.out.println("SQL statement is not executed! Error is: " + sq.getMessage());
        		
	}
			
		}
	} catch (SQLException s) {
		System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void show1(String a,String b,String c,String d,String e,String f)
{
	try
	{
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

Statement st = connection.createStatement();

      //  st.setString(1,s1);
       // st.setString(2, s2);
        int rs = st.executeUpdate("insert personal values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')");
       
}
	catch (SQLException s) {
		System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
		
}
}
public void show2(String a,String b,String c,String d)
{
	try
	{
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root", "");

Statement st = connection.createStatement();

      //  st.setString(1,s1);
       // st.setString(2, s2);
        int rs = st.executeUpdate("insert extrainfo values('"+a+"','"+b+"','"+c+"','"+d+"')");
       
}
	catch (SQLException s) {
		System.out.println("SQL statement is not executed! Error is: " + s.getMessage());
		
}
}
}