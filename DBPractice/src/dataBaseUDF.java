import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class dataBaseUDF {
	private static Connection connection;
	
	
	///load driver  
	///connect to database
	///statement 
	//execute statement
	//result verify 
	
	public static ResultSet rs;
	////connect to DB
	public static ResultSet fnResult(String driverName, String dbURL, String userName, String password, String selectquery) throws ClassNotFoundException, SQLException
	{
 
	        //Load MySQL JDBC Driver
			Class.forName(driverName);
	        
	        //Creating connection to the database
	        Connection con = DriverManager.getConnection(dbURL,userName,password);
	        
	        //Creating statement object
	    	Statement st = con.createStatement();
	    	
	    	 
	        
	    	//Executing the SQL Query and store the results in ResultSet
	    	ResultSet rs = st.executeQuery(selectquery);
	    	
	    	
	    	//While loop to iterate through all data and print results
	    	/*while (rs.next()) 
	    	{
			     System.out.println(rs.getString("NAME"));
			     System.out.println(rs.getString("AGE"));
			     System.out.println(rs.getString("DEPT"));
			     System.out.println(rs.getString("ADVISER"));
			     
			     //System.out.println(rs.getType());
			  }*/
	    	
	/*    ////get schema name
		     ResultSet resultSet = con.getMetaData().getCatalogs();
		     while (resultSet.next()) {
		       System.out.println("Schema Name = " + resultSet.getString("TABLE_CAT"));
		     }
	        */
	    	return rs;
	   /* 		    	
	    	///close resultset
	    	rs.close();
	    	//close statement  
	    	st.close();    	
	    	//Closing DB Connection
	    	con.close();*/  		    	
	 }
}
