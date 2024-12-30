package Pom_Elements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableMethods;
import Utilities.BaseAbstractMethods;

public class AccountCreationPage extends BaseAbstractMethods{
 WebDriver driver;
 ReusableMethods reuse;	
 public AccountCreationPage(WebDriver superdriver) {
	    super(superdriver);
		this.driver = superdriver;
		PageFactory.initElements(driver,this);
	}
 
 @FindBy(xpath="//span[@class='base']") WebElement createNewCustomerText;
 @FindBy(xpath="//input[@name='firstname']") WebElement firstname;
 @FindBy(xpath="//input[@name='lastname']") WebElement lastname;
 @FindBy(xpath="//input[@name='email']") WebElement email;
@FindBy(xpath="//input[@id=\"password\"]") WebElement password;
@FindBy(xpath="//input[@id=\"password-confirmation\"]") WebElement confirmpw;
@FindBy(xpath="//button[@class=\"action submit primary\"]") WebElement createAccBtn;
@FindBy(xpath="//div[text()='Invalid Form Key. Please refresh the page.']") WebElement invalidFormError;
//@FindBy(xpath="(//span[@class="logged-in"])[1]") WebElement customerFullname;
@FindBy(xpath="//div[contains(text(),'There is already an account with this email address')]") WebElement alreadyHaveAccMsg;
//@FindBy(xpath="") WebElement a;
 

 public MyAccount accountCreation() throws FileNotFoundException {
	 implicitwaitMethod();
	 reuse = new ReusableMethods(driver);
	 reuse.verifyUrl("https://magento.softwaretestingboard.com/customer/account/create/");
	 reuse.verifyTitle("Create New Customer Account");
	 reuse.verify_SingleText_Visibility(createNewCustomerText, "Create New Customer Account");	
	 try {
	 Properties prop = new Properties();
	 FileInputStream fis = new FileInputStream(
			 System.getProperty("user.dir")+("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
	 prop.load(fis);
	 //form Data from GlobalInputs properties
	 String fname = prop.getProperty("firstname");
	 firstname.sendKeys(fname);
	 String lname = prop.getProperty("lastname");
	 lastname.sendKeys(lname);
	// String email = prop.getProperty("email");
	// Unique email
	 String emailId = "Minnu" + System.currentTimeMillis() + "@gmail.com"; 
	 email.sendKeys(emailId);
	 String pass = prop.getProperty("password");
	 password.sendKeys(pass);
	 scrollToElementBeforeClicking(confirmpw);
	 String cpw = prop.getProperty("confirmpassword");
	 confirmpw.sendKeys(cpw);
	 createAccBtn.click();
	 System.out.println("Create an Account Button Clicked----");
	 }
	 catch(Exception e){
		 e.printStackTrace();
		 }
	 
	 MyAccount myAccout = new MyAccount(driver);
	 return myAccout;
	 
 }
 
 public void InvalidAccountDetails() throws FileNotFoundException {
	 reuse = new ReusableMethods(driver);
	 try {
	 Properties prop = new Properties();
	 FileInputStream fis = new FileInputStream(
			 System.getProperty("user.dir")+("\\src\\main\\java\\TestData\\GlobalInputs.properties"));
	 prop.load(fis);
	 //form Data from GlobalInputs properties
	 String fname = prop.getProperty("firstname");
	 firstname.sendKeys(fname);
	 String lname = prop.getProperty("lastname");
	 lastname.sendKeys(lname);
	 String emailId = prop.getProperty("email"); 
	 email.sendKeys(emailId);
	 String pass = prop.getProperty("password");
	 password.sendKeys(pass);
	 scrollToElementBeforeClicking(confirmpw);
	 String cpw = prop.getProperty("confirmpassword");
	 confirmpw.sendKeys(cpw);
	 createAccBtn.click();
	 reuse.verifySingleElementVisibility(alreadyHaveAccMsg);
	 driver.navigate().refresh();
	 }
	 catch(Exception e){
		 e.printStackTrace();
		 System.out.println("----InvalidAccountDetails----");
		 }
	 
 }
 
}
