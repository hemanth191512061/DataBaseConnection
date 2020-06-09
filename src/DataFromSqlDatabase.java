import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class DataFromSqlDatabase {
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver web = new ChromeDriver();
		web.get("https://www.facebook.com");
	String url="jdbc:mysql://localhost:3306/nani";
	//Class.forName("com.mysql.jdbc.Driver");
	Connection connect=DriverManager.getConnection(url,"root","Hemanth143");
	
	Statement s=connect.createStatement();
	ResultSet result=s.executeQuery("select * from employeeinfo where name='hemanth';");
	result.next();
	web.findElement(By.id("email")).sendKeys(result.getString("name"));
	//System.out.println(result.getString("location"));
}
}
