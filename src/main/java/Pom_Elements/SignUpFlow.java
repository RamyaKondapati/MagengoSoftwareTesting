package Pom_Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableMethods;
import Utilities.BaseAbstractMethods;

public class SignUpFlow extends BaseAbstractMethods{
	 WebDriver driver;
	 ReusableMethods reuse;	
	 public SignUpFlow(WebDriver superdriver) {
		    super(superdriver);
			this.driver = superdriver;
			PageFactory.initElements(driver,this);
		}
	 
	 @FindBy(xpath="(//a[text()='Create an Account'])[1]") WebElement createAnAccountLink;
	 @FindBy(xpath="//input[@name='firstname']") WebElement firstname;
	 @FindBy(xpath="//input[@name='lastname']") WebElement lastname;
	 @FindBy(xpath="//input[@name='email']") WebElement email;
	@FindBy(xpath="//input[@id=\"password\"]") WebElement password;
	@FindBy(xpath="//input[@id=\"password-confirmation\"]") WebElement confirmpw;
	@FindBy(xpath="//button[@class=\"action submit primary\"]") WebElement createAccBtn;
	@FindBy(xpath="//div[text()='Thank you for registering with Main Website Store.']") WebElement thankYouMsg;
	@FindBy(xpath="(//span[@class=\"logged-in\"])[1]") WebElement customerFullname;

	//click on create an account
	public void createAccount() {
		createAnAccountLink.click();
	}
	
	// Existing methods
    public void enterFirstName(String firstName) {
    	firstname.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
    	lastname.sendKeys(lastName);
    }

    public void enterEmail(String emailid) {
       email.sendKeys(emailid);
    }

    public void enterPassword(String pass) {
       password.sendKeys(pass);
    }

    public void confirmPassword(String cpass) {
    	confirmpw.sendKeys(cpass);
    }

    public void clickCreateAccount() {
    	createAccBtn.click();
    }

    public String getSuccessMessage() {
    	return thankYouMsg.getText();
    }

    // New method to get welcome message
    public String getWelcomeCustomerName() {
    	visibilityOfElementLocated(customerFullname,10);
    	return customerFullname.getText();
    }
}
	

