package Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	
	/* *AUTHOR: ESTHER
	 * when we get element click intercepted exception (when element is hidden by other element) 
	 * then we will use java script click()
	 * @param driver
	 * @param ele
	 */
public void javaScriptClick(WebDriver driver, WebElement ele) {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ele);
}
/**
 * to avoid ElementclickinterceptedException
 * @param driver
 * @param ele
 * @param data
 */

public void javaScriptSendKeys(WebDriver driver, WebElement ele, String data) {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].value=arguments[1];", ele,data);

}
/**author: Esther
 * this method will scroll the webpage till the given element
 * @param driver
 * @param ele
 */

public void javaScriptScrollTillElement(WebDriver driver, WebElement ele) {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	}

/**
 * author: esther
 * this method will scroll the webpage with the given coordinates
 * @param driver
 * @param xcoordinate
 * @param ycoordinate
 */
public void javaScriptScrollByCoordinates(WebDriver driver, int xcoordinate, int ycoordinate) {

	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("scrollBy("+xcoordinate+","+ycoordinate+");");

}
/**author= esther
 * this method will highlight the webelement with 2px red colour
 * 
 * @param driver
 * @param ele
 */

public void javaScriptHighLightWebelement(WebDriver driver, WebElement ele) {
	JavascriptExecutor jse=(JavascriptExecutor)driver;
jse.executeScript("argument[0].style.border='2px solid red';", ele);
}
/**to perform mouse over operation on webelement
 * 
 * @param driver
 * @param ele
 */
public void mouseOverAction(WebDriver driver, WebElement ele) {
Actions action=new Actions(driver);	
action.moveToElement(ele).perform();;
}
/**
 * to perform right click operation on webelemenr
 * @param driver
 * @param ele
 */
public void rightClick(WebDriver driver, WebElement ele) {
	Actions action=new Actions(driver);	
	 action.contextClick(ele).perform();;
}
/**
 * to perform double click operation on webelement
 * @param driver
 * @param ele
 */
public void doubleClick(WebDriver driver, WebElement ele) {
	Actions action=new Actions(driver);	
	action.doubleClick(ele).perform();;

}
/**
 * to perform drag and drop operation between 2 elements
 * @param driver
 * @param draggingElement
 * @param droppingElement
 */
public void dragAndDrop(WebDriver driver, WebElement draggingElement, WebElement droppingElement) {
	Actions action=new Actions(driver);	
	action.dragAndDrop(draggingElement, droppingElement).perform();;
}
/**
 * to perform click and hold operation on webelement
 * @param driver
 * @param ele
 */
public void clickAndHold(WebDriver driver, WebElement ele) {
	Actions action=new Actions(driver);	
action.clickAndHold(ele).perform();
}
/**
 * to perform scrolling of webpage till the element
 * @param driver
 * @param ele
 */
public void scrollToWebElementByActionsClass(WebDriver driver, WebElement ele) {
	Actions action=new Actions(driver);	
action.scrollToElement(ele).perform();
}
/**
 * this method will wait until given element reaches a clickable state
 * @param driver
 * @param locator
 */
public void explicitlyWaitForElementToBeClickable(WebDriver driver, By locator) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(locator));
}
/**
 * this method will wait until given element is visible
 * @param driver
 * @param ele
 * @param timeDelay
 */
public void explicitlyWaitForElementToBeVisible(WebDriver driver, WebElement ele, int timeDelay) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
	wait.until(ExpectedConditions.visibilityOf(ele));
	
}
/**
 * this method will wait until alert is present
 * @param driver
 * @param timeDelay
 */
public void explicitlyWaitForAlert(WebDriver driver, int timeDelay) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
	wait.until(ExpectedConditions.alertIsPresent());
	
}
/**
 * this method will wait until particular page or particular url appears
 * @param driver
 * @param timeDelay
 * @param Completeurl
 */
public void explicitlyWaitForUrl(WebDriver driver, int timeDelay, String Completeurl) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
wait.until(ExpectedConditions.urlToBe(Completeurl));
}
/**
 * this method will wait until particular page is displayed/appears
 * @param driver
 * @param timeDelay
 * @param CompleteTitle
 */
public void explicitlyWaitForTitle(WebDriver driver, int timeDelay, String CompleteTitle) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeDelay));
wait.until(ExpectedConditions.titleIs(CompleteTitle));
}}