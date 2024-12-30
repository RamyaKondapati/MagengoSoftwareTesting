
package TestScripts_Magento;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pom_Elements.AccountCreationPage;
import Pom_Elements.CustomerLogin;
import Pom_Elements.HomepageLuma;
import Pom_Elements.MyAccount;
import Pom_Elements.SignOutpage;
import Pom_Elements.SignUpFlow;
import dev.failsafe.internal.util.Assert;

public class SignUpFlowTestScript {
  WebDriver driver;

	@BeforeTest
	public void setupBrowser_And_LaunchUrl() throws IOException {
		// load properties file
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
		props.load(fis);
		// initializing browser
		String browser = props.getProperty("browsername");
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		// launch Application
		driver.manage().window().maximize();
		String url = props.getProperty("url");
		driver.get(url);
		System.out.println("Application Launched Successfully");
	}
	
//	@AfterTest
//	public void closeBrowser() {
//		driver.quit();
//		System.out.println("Browser Quit");
//	}
	
	//creating an account on the MagentoSoftwareTesting website and signing in with that account.
	
		@Test
		public void testAccountCreation() {
			SignUpFlow signup = new SignUpFlow(driver);
			SignOutpage signout = new SignOutpage(driver);
			signup.createAccount();
	        // Form Data
	        String firstName = "Ramya";
	        String lastName = "Kondapati";
	        String email = "Minnu" + System.currentTimeMillis() + "@gmail.com"; // Unique email
	        String password = "janu@2021";

	        // Fill out the form
	        signup.enterFirstName(firstName);
	        signup.enterLastName(lastName);
	        signup.enterEmail(email);
	        signup.enterPassword(password);
	        signup.confirmPassword(password);

	        // Submit the form
	        signup.clickCreateAccount();

	        // Assert success message
	        String successMessage = signup.getSuccessMessage();
	        assertTrue(successMessage.contains("Thank you for registering"), "Account creation failed!");

	        // Verify welcome message
	        String welcomeMessage = signup.getWelcomeCustomerName();
	        String expectedWelcomeMessage = "Welcome, " + firstName + " " + lastName + "!";
	        assertEquals(welcomeMessage, expectedWelcomeMessage, "Welcome message is incorrect!");
	        
	        signout.signOutMagento();
	        
	    }
	
}
