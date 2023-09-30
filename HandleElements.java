package selenium;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project {

	public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
	
		// Code for removing push notification:
				//Create a class to handle external elements.  (Alerts)
				String dburl = "jdbc:mysql://localhost:3306/project";
				String username = "root";
				String password = "Arpitajoshi@2000";
				
		         Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con = DriverManager.getConnection(dburl,username,password);
				
				ChromeOptions options = new ChromeOptions();
				
				options.addArguments("--disable-notifications");
				
				WebDriver driver = new ChromeDriver(options);
				
				driver.manage().window().maximize();
				
				driver.manage().deleteAllCookies();
				
				driver.get("https://www.redbus.com/");
				
				String title = driver.getTitle();
				
				//get the url of the tab opened
				
				String url = driver.getCurrentUrl();
				PreparedStatement ps = con.prepareStatement("insert into product_data values(?,?)"); // execute query
				ps.setString(1,title);
				ps.setString(2,url);
				//execute
				
				ps.executeUpdate();
				
				//make connection to the mysql
				driver.findElement(By.xpath("//button[@class = 'sc-fjdhpX jxFepI']")).click();
				
				Thread.sleep(1500);
				
				// We will not make driver object to switch from main window of app to alert window
				// once we switch to alery we will use Alert class object to perform actions on the alert
				// we can perform 3 actions on the alert : getText, send keys, press ok or cancel button
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				

				//Alert a = driver.switchTo().alert();

				//String alertText= a.getText();
				//System.out.println(alertText);
				
				//a.accept();

				// Clear the source text box
				
				driver.findElement(By.xpath("//div[@class='main-wrapper search-box-wrapper']/descendant::input[1]")).clear();
			
			// enter input string in text box
				
				driver.findElement(By.xpath("//div[@class='main-wrapper search-box-wrapper']/descendant::input[1]")).sendKeys("Paris");
						
				Thread.sleep(5000);
						// capture element form the list
			//	driver.findElement(By.xpath("//div[@class='autoFill autosuggest-ul rdc-src']/descendant::li[3]")).click();
						
						// destination
				driver.findElement(By.xpath("//div[@class='main-wrapper search-box-wrapper']/descendant::input[2]")).clear();
				
				driver.findElement(By.xpath("//div[@class='main-wrapper search-box-wrapper']/descendant::input[2]")).sendKeys("London");
					
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//div[@class='autoFill autosuggest-ul rdc-dest']/descendant::li[3]")).click();
					
				//calander
				
				Thread.sleep(3000);
				
				driver.findElement(By.id("date-box")).click();
				
				Thread.sleep(5000);
				
				//Select date
				
				driver.findElement(By.xpath("//div[@class='DatePicker__CalendarContainer-sc-1x9sb82-0 bkhtIz']/descendant::span[41]")).click();
				
				Thread.sleep(5000);	
						   
			 //click on search button
				 driver.findElement(By.id("search_butn")).click();
				// Upload file using autoIT
					
					driver.get("https://www.remove.bg/");
					// Wait for page to load (you can adjust the sleep time)
					Thread.sleep(5000);


					
					// handle webelement using mouse hover
					
					driver.get("https://www.amazon.com/");
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					
					WebElement e2 = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
					
					
					Actions ab = new Actions(driver);
					
					
					ab.moveToElement(e2).perform();
					
					Thread.sleep(5000);
					
					driver.findElement(By.xpath("(//span[@class='nav-text'])[7]")).click();
					
					File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File destFile = new File("./Screenshots/project.png");

					FileUtils.copyFile(srcFile, destFile);

}
}