package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountsettingspage {
	public WebDriver driver;
	public Accountsettingspage (WebDriver driver){
		PageFactory.initElements(driver,this);
}
@FindBy(xpath="//*[name()='svg'and@data-testid='LogoutIcon']")
private WebElement LogOutButton;

public WebElement getLogOutButton() {
return LogOutButton;

}
@FindBy(xpath="//li[text()='My Profile']")
private WebElement MyProfileLink;

public WebElement getMyProfileLink() {
	return MyProfileLink;
}
}
