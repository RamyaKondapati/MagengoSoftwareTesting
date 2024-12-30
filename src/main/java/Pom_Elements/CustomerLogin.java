package Pom_Elements;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableMethods;
import Utilities.BaseAbstractMethods;

public class CustomerLogin extends BaseAbstractMethods{
	 WebDriver driver;
	 ReusableMethods reuse;	
	 
	 public CustomerLogin(WebDriver superdriver) {
		    super(superdriver);
			this.driver = superdriver;
			PageFactory.initElements(driver,this);
		}
	 
	 @FindBy(xpath="//input[@id=\"email\"]") WebElement customerEmail;
	 @FindBy(xpath="//input[@name=\"login[password]\"]") WebElement customerPass;
	 @FindBy(xpath="(//button[@name='send'])[1]") WebElement signInButton;


	 public void existingCustomerLogin() {
		 visibilityOfElementLocated(signInButton,10);
		 try {
			 Properties prop = new Properties();
			 FileInputStream fis = new FileInputStream(
					 System.getProperty("user.dir")+("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
			 prop.load(fis);
			 //Existing Customer login
			 String email = prop.getProperty("email");
			 customerEmail.sendKeys(email);
			 String pass = prop.getProperty("password");
			 customerPass.sendKeys(pass);
			 signInButton.click();
			 System.out.println("--- SignIn Successfull ----");
			 MyAccount myacc = new MyAccount(driver);
			 myacc.signOut();
			 }
			 catch(Exception e){
				 e.printStackTrace();
				 }
	 }
	 
}
