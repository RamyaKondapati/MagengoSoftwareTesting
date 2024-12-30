package Pom_Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableMethods;
import Utilities.BaseAbstractMethods;

public class MyAccount extends BaseAbstractMethods{
	 WebDriver driver;
	 ReusableMethods reuse;	
	 public MyAccount(WebDriver superdriver) {
		    super(superdriver);
			this.driver = superdriver;
			PageFactory.initElements(driver,this);
		}
	 
	@FindBy(xpath="(//span[@class=\"logged-in\"])[1]") WebElement customerFullname;
	@FindBy(xpath="//div[text()='Thank you for registering with Main Website Store.']") WebElement thankYouMsg;
	@FindBy(xpath="(//button[@class=\"action switch\"])[1]") WebElement dropdownArrow ;
	@FindBy(xpath="(//a[contains(text(),'Sign Out')])[1]") WebElement signOutBtn;	
	@FindBy(xpath="(//a[contains(text(),'Sign In')])[1]") WebElement signInLink;
	
	public void welcomeCustomer() {
		reuse = new ReusableMethods(driver);
		visibilityOfElementLocated(customerFullname,10);
		//reuse.elementAvailable(customerFullname, true);
		reuse.verifySingleElementVisibility(customerFullname);
		reuse.getText_Of_Element(thankYouMsg);
		System.out.println("--- welcome ("+customerFullname.getText() +")--- Displayed ");
		
	}
	public void signOut() {
		waitForElementToBeClickable(dropdownArrow,10);
		dropdownArrow.click();
		waitForElementToBeClickable(signOutBtn,10);
		signOutBtn.click();
		System.out.println("--- SignOut ----");
	}
	public CustomerLogin clickOnsignInLink() {
		waitForElementToBeClickable(signInLink,10);
		signInLink.click();
		
		CustomerLogin loginCustomer = new CustomerLogin(driver);
		return loginCustomer;
	}	 
		 
		 
	 
}
