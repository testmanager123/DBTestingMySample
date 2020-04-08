
	

import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DBTesting {
     public static void main(String[] args) throws SQLException, ClassNotFoundException { 
 String dbURL = "jdbc:mysql://localhost:3306/emp?useSSL=false";
 String username = "root";
        String password = "tester";
        //Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Creating connection to the database
        Connection con = DriverManager.getConnection(dbURL,username,password);
        //Creating statement object
    	Statement st = con.createStatement();
    	String selectquery = "SELECT * FROM employee  where ADVISER='SRINIVASA'";
        //Executing the SQL Query and store the results in ResultSet
    	ResultSet rs = st.executeQuery(selectquery);
    	//While loop to iterate through all data and print results
    	while (rs.next()) {
     System.out.println(rs.getString("NAME"));
     System.out.println(rs.getString("AGE"));
     System.out.println(rs.getString("DEPT"));
     System.out.println(rs.getString("ADVISER"));
     
     //System.out.println(rs.getType());
    	}
        //Closing DB Connection
    	con.close();
 }
}