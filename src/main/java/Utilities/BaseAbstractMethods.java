package Utilities;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseAbstractMethods {

	WebDriver driver;
	WebDriverWait wait;
	public BaseAbstractMethods(WebDriver driversuper)
	{
		this.driver = driversuper;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	}
	
	public void implicitwaitMethod()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	public WebElement waitForElementToBeClickable(WebElement element, int i) {

		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement visibilityOfElementLocated(WebElement ele, int i) {

		return wait.until(ExpectedConditions.visibilityOf(ele));

	}
	
	public List<WebElement> visibilityOfMultipleElementLocated(List<WebElement> ele, int i) {

		return wait.until(ExpectedConditions.visibilityOfAllElements(ele));

	}
	public void scrollToElementBeforeClicking(WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		//element.click();
	}
	public void hoverAnyElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public void doubleClick(WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	public void rightClick(WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	public void dragAndDrop(WebElement element,WebElement targetElement)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(element, targetElement).build().perform();
	}
	
	
}
