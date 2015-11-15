package connection;

import java.sql.*;
import java.util.Properties;
/**
* DBDemo Class enable to connect mysql database table called members
* and retrieve value from the table and print value.
*
* The source to URL: https://help.ubuntu.com/community/JDBCAndMySQL
*
* @author David Sajdl
*/
public class DBDemo {

	 // The JDBC Connector Class.
	  private static final String dbClassName = "com.mysql.jdbc.Driver";

	  private static final String CONNECTION = "jdbc:mysql://127.0.0.1/my_first_database";

	public static void main(String[] args)throws ClassNotFoundException,SQLException {

		    System.out.println(dbClassName);
		    // Class.forName(xxx) loads the jdbc classes and
		    // creates a drivermanager class factory
		    Class.forName(dbClassName);

		    // Properties for user and password.
		    Properties p = new Properties();
		    p.put("user","yourUserName");
		    p.put("password","yourPassword");

		    // Now to connect
		    Connection c = DriverManager.getConnection(CONNECTION,p);
		    Statement con = c.createStatement();
		    ResultSet resSet = con.executeQuery("SELECT * FROM members");
		    while(resSet.next()){
		    	System.out.println(resSet.getString("member_id") + ", " + resSet.getString("first_name")
		    			+ ", " + resSet.getString("last_name") +", " + resSet.getString("email") + ", "
		    			+ resSet.getString("username") +", " + resSet.getString("date_birthday") +", " + resSet.getString("gender")
		    			+ ", " + resSet.getString("location"));
		    }
		    c.close();
    }
}
