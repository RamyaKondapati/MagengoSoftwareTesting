package Pom_Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableMethods;
import Utilities.BaseAbstractMethods;

public class HomepageLuma extends BaseAbstractMethods {

	WebDriver driver;
	 ReusableMethods reuse;	
	 public HomepageLuma(WebDriver superdriver) {
		    super(superdriver);
			this.driver = superdriver;
			PageFactory.initElements(driver,this);
		}
	 
	 @FindBy(xpath="(//a[text()='Create an Account'])[1]") WebElement createAnAccountLink;
	// @FindBy(xpath="") WebElement a;
	// @FindBy(xpath="") WebElement a;
	// @FindBy(xpath="") WebElement a;
	 
	 
	 public AccountCreationPage lumaLandingPage() {
		 implicitwaitMethod();
		 reuse = new ReusableMethods(driver);
		 reuse.verifyUrl("https://magento.softwaretestingboard.com/");
		 reuse.verifyTitle("Home Page");
		 //click on create an Account for creating account
		 createAnAccountLink.click();
		 System.out.println("------- Start Creating an Account  -----");
		 AccountCreationPage accountpage = new AccountCreationPage(driver);
		 return accountpage;
	 }
}
