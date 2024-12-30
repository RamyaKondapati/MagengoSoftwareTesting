package Utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ReusableMethods {
	
	WebDriver driver;
	public ReusableMethods(WebDriver superdriver) {
		this.driver = superdriver;
		PageFactory.initElements(driver, this);
	}

	public void verifyUrl(String expectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		assertEquals(actualUrl, expectedUrl, "Url --> (" + actualUrl + ") != (" + expectedUrl + ")");
	}

	public void verifyTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle,expectedTitle," Title --> ("+actualTitle+") != ("+expectedTitle+") "); 
	}
	
	public void verify_SingleText_Visibility(WebElement element, String expectedText) {
		String actualtext = element.getText();
		assertEquals(actualtext, expectedText, "(" + actualtext + ") != (" + expectedText + ")");
	}

	public void verifyMultipleElementsVisibility(List<WebElement> element) {
		System.out.println("List of multiple elements text -> ");
		for (WebElement multiText : element) {
			boolean actualText = multiText.isDisplayed();
			assertTrue(actualText, "List of Multiple Elements not Displayed");
			System.out.println(multiText.getText());
		}

	}
	// Method to verify whether the element is available in the application or not
		public void elementAvailable(WebElement element, boolean expectedValue) {
			boolean actualValue = element.isDisplayed();
			assertEquals(actualValue, expectedValue);
			System.out.println(actualValue);
		}

	public void verifySingleElementVisibility(WebElement element) {
		boolean actualvalue = element.isDisplayed();
		String displayedElement = element.getText();
		assertTrue(actualvalue, "Element Not Displayed");
		System.out.println("Displayed ->(" + actualvalue + ") -- (" + displayedElement + ")");
	}

	public void isElementEnabled(WebElement element) {
		boolean actualValue = element.isEnabled();
		assertTrue(actualValue, "Element not enabled");
	}

	public void isElementSelected(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isEnabled();
		assertEquals(actualValue, expectedValue,"(" + actualValue + ") != (" + expectedValue + ")");
	}

	// Method to verify getText
	public String getText_Of_Element(WebElement element) {
		return element.getText();
		
	}

	// Method to verify Image visibility
	public void imageVisibility(WebElement ImageFile) {
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);
		if (!ImagePresent) {
			System.out.println("Image not displayed.");
		} else {
			System.out.println("Image displayed.");
		}
	}

	public String getEnteredText(WebElement elem) {
		return elem.getAttribute("value");
		
	}
	
}
