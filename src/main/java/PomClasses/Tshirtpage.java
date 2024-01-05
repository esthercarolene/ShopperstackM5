package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tshirtpage {
	public WebDriver driver;
	public Tshirtpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='men tshirt']")
	private WebElement tshirtTopLink;
	
	public WebElement gettshirtTopLink() {
		return tshirtTopLink;
	}
	
	@FindBy(xpath="//span[text()='Levis Mens Regular Fit Tee']/../..//button")
	private WebElement levisMensRegularfitproduct_AddTOCartButton;
	
	public WebElement gettlevisMensRegularfitproduct_AddTOCartButton() {
		return levisMensRegularfitproduct_AddTOCartButton;
	}}
