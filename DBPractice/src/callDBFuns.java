import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.cj.protocol.x.ResultMessageListener;

public class callDBFuns 
{

	private static String dbURL = "jdbc:mysql://localhost:3306/emp?useSSL=false";
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String userName = "root";
	private static String password = "tester";
	private static Connection connection;
	
	private static String selectquery= "SELECT * FROM employee where DEPT=20";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		
		ResultSet myRes  = dataBaseUDF.fnResult(driverName, dbURL, userName, password, selectquery);
		/*while(myRes.next())
		{
			String AppName = myRes.getString("NAME");
			if((AppName.equalsIgnoreCase("SRINIVASA"))==true)
			{
				System.out.println("Name is exist " + AppName);
				break;
			}
			else
			{
				System.out.println("not exist name " +AppName);
			}
		}
		*/
		//While loop to iterate through all data and print results
		int rows =0;
    	while (myRes.next()) 
    	{
    		System.out.println(myRes.getString("NAME"));
		    System.out.println(myRes.getString("AGE"));
		    System.out.println(myRes.getString("DEPT"));
		    System.out.println(myRes.getString("ADVISER"));
		    rows = rows+1;		    
    	}
    //	System.out.println(rows);
    	myRes.last();
    	System.out.println("no of rows are  : " +myRes.getRow());
    	System.out.println("no of rows are  : " +rows);
    	System.out.println("Schema name  : " +myRes.getMetaData().getSchemaName(1));
    	System.out.println("table name  : " +myRes.getMetaData().getTableName(1));
	    System.out.println("no of columns are  : "+myRes.getMetaData().getColumnCount());
	    
	    for(int i=1; i<=myRes.getMetaData().getColumnCount(); i++)
	    {
	    	System.out.println(myRes.getMetaData().getColumnName(i));
	    }
	}
	///schema name
	///table count and table names
	///column and row count  
	///column names (column is exist or not)
	///cell data
}
