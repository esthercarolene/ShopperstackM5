package Utility;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PomClasses.Accountsettingspage;
import PomClasses.Homepage;
import PomClasses.Loginpage;
import PomClasses.Welcomepage;

public class BaseClass{	
	public static WebDriver driver;
	public	DataUtility du = new 	DataUtility();
	public WebdriverUtility wu=new WebdriverUtility();
	public DropdownUtility drpU=new DropdownUtility();

	@BeforeClass
	public void lanchingBrowser() throws Throwable {
	System.out.println("---------lanchingBrowser------------");	
	String BROWSER=du.dataFromPropertiesFile("browser");

	if(BROWSER.equals("chrome")) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
	}
	else if(BROWSER.equals("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equals("edge")) {
		driver=new EdgeDriver();
	}
	else {
		driver=new ChromeDriver();
	}
	String URL=du.dataFromPropertiesFile("url");
	
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@BeforeMethod
	public void loginToApplication() throws Throwable {
	System.out.println("---------login TO application----------");

	Welcomepage WLpage = new Welcomepage(driver);
	WLpage.getMainLoginButton().click();

	Loginpage Lpage = new Loginpage(driver);

	String emailId = du.dataFromPropertiesFile("email");
	Lpage.getEmailTextField().sendKeys(emailId);

	String Password=du.dataFromPropertiesFile("password");
	Lpage.getPasswordTextField().sendKeys(Password);

	Lpage.getLoginButton().click();

	}

	@AfterMethod
	public void logoutFromApplication() throws Throwable {
		System.out.println("----------logout from application-------");
		Thread.sleep(6000);
		Homepage Hpage=new Homepage(driver);
		
		Hpage.javaScriptClick(driver);
		Thread.sleep(3000);
		Accountsettingspage as=new Accountsettingspage (driver);
		as.getLogOutButton().click();
	}

	@AfterClass
	public void quitBrowser() {
	System.out.println("----------quit the browser----------");	
	driver.quit();
	}}