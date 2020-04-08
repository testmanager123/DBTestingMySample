import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataReadFromDB {
	private static String dbURL = "jdbc:mysql://localhost:3306/mytest?useSSL=false";
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String userName = "root";
	private static String password = "tester";
	private static Connection connection;
	
	private static String selectquery= "SELECT * FROM userdata";


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		////set browser path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srinivas\\Desktop\\EclipseNew\\chromedriver.exe");
		
		///create browser instance
		WebDriver myApp = new ChromeDriver();
		
		///open test app
		myApp.navigate().to("http://www.facebook.com");
		
		WebElement fname = myApp.findElement(By.name("firstname"));
		WebElement lname = myApp.findElement(By.name("lastname"));
		
		
		ResultSet mytestData = dataBaseUDF.fnResult(driverName, dbURL, userName, password, selectquery);
		
		while (mytestData.next())
		{
			System.out.println(mytestData.getString("Firstname"));
			fname.sendKeys(mytestData.getString("Firstname"));
			
			System.out.println(mytestData.getString("Lastname"));
			lname.sendKeys(mytestData.getString("Lastname"));
			System.out.println(mytestData.getString("UEmail"));
			System.out.println(mytestData.getString("UREmail"));
			System.out.println(mytestData.getString("UMobile"));
			System.out.println(mytestData.getString("Password"));
			
			
		}
		

	}

}

