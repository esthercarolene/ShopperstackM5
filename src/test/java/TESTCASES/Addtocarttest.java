package TESTCASES;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PomClasses.Accountsettingspage;
import PomClasses.Addressformpage;
import PomClasses.Addresspage;
import PomClasses.Addtocartpage;
import PomClasses.Homepage;
import PomClasses.Myaddresspage;
import PomClasses.Myprofilepage;
import PomClasses.Netbankingpage;
import PomClasses.Orderconfirmpage;
import PomClasses.Paymentmethod;
import PomClasses.Tshirtpage;
import Utility.BaseClass;
@Listeners(Utility.ListenersUtility.class)
public class Addtocarttest extends BaseClass {
	
	//public void  Tc_AddToCart_001_Test() throws Throwable {
		//String URL=data.dataFromPropertiesFile("url");
		//System.out.println(URL);

		//File file=new File ("C:\\Users\\Carolene\\eclipse-workspace\\Shoppersstack_M5\\src\\main\\resources\\Credentials.properties");
		//FileInputStream fis=new FileInputStream(file);
		//Properties pr=new Properties();
		//pr.load(fis);
		//String Url=pr.getProperty("url");
		//System.out.println(Url);
		//String BROWSER = pr.getProperty("browser");
		//System.out.println(BROWSER);
	//}
		//public String  Tc_AddToCart_002_Test() throws Throwable {
			//File file=new File("C:\\Users\\Carolene\\eclipse-workspace\\Shoppersstack_M5\\src\\main\\resources\\testdata5.xlsx");	
			//FileInputStream fis=new FileInputStream(file);
		
		//Workbook workbook=WorkbookFactory.create(fis);
		//Sheet sheet =workbook.getSheet("Sheet1");
		//Row row=sheet.getRow(0);
		//Cell cell = row.getCell(1);

		//DataFormatter formatter=new DataFormatter();
		//String value=formatter.formatCellValue(cell);
		//System.out.println(value);
		//return value;
		//}
		
	
	@Test(dataProvider="dataProviderAddress")
	public void Tc_AddAddress_001_Test(String home,String house_office,
		String street,String landmark,String country,String state,String city,String Dpin,String mobN) throws Throwable {
		System.out.println("add address");
		 Thread.sleep(5000);
		 Homepage hp=new Homepage(driver);
		 hp.javaScriptClick(driver);
	
		 Thread.sleep(3000);
		Accountsettingspage as=new Accountsettingspage(driver);
		as.getMyProfileLink().click();
Assert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/my-profile/my-profile-info");

		System.out.println("The my profile  page is opened");
		Myprofilepage mp=new Myprofilepage(driver);
		mp.getmyAddressLink().click();
		
		Myaddresspage  ma=new Myaddresspage (driver);
		
		ma.getaddressformbutton().click();
		
		Addressformpage afp=new Addressformpage(driver);
		afp.getnameTF().sendKeys(home);
		afp.gethouseofofficeTF().sendKeys(house_office);
		afp.getstreetinfoTF().sendKeys(street);
		afp.getlandmarkTF().sendKeys(landmark);
		WebElement counrtyDropdown=afp.getcountryTFDropDown();
		drpU.selectDropDownByVisibleText(country,counrtyDropdown);
		WebElement StateDropdown=afp. getstateDropDown();
		drpU.selectDropDownByVisibleText(state,StateDropdown);
		WebElement CityDropdown=afp.getcityDropDown();
		drpU.selectDropDownByVisibleText(city,CityDropdown);
		afp.getpincodeTF().sendKeys(Dpin);
		afp.getphonenumberTF().sendKeys(mobN);
		afp.getaddaddressButton().click();		
	}
	
	@DataProvider
	public Object[][] dataProviderAddress() throws Throwable{	
		return du.aceessAllAddress();
	}
	

	
	@Test(priority=1,dependsOnMethods="Tc_AddAddress_001_Test")
	public void Tc_EndToEndCashOnDelivery_Test() throws Throwable {	
	Thread.sleep(3000);
    System.out.println("first test case");
    String titleHomePage=driver.getTitle();
    Assert.assertEquals(titleHomePage,"ShoppersStack | Home"); 
    Homepage hp=new Homepage(driver);
    Thread.sleep(5000);
    WebElement menLink=hp.getmenMenuLink(); 
    wu.mouseOverAction(driver,menLink);  
    hp.getTshirtPopupLink().click();  
    Tshirtpage tsp=new Tshirtpage(driver);
String currentUrl=driver.getCurrentUrl();
  Assert.assertEquals(currentUrl,"https://www.shoppersstack.com/sub-category/men-tshirt"); 
  wu.mouseOverAction(driver,tsp.gettshirtTopLink());
    tsp.gettlevisMensRegularfitproduct_AddTOCartButton().click();    hp.getaddToCartLink().click();
   Assert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/cart"); 
    System.out.println("The cart page has opened");
   
   Addtocartpage ac=new Addtocartpage(driver);
   String levisProductTest= ac.getlevisProduct().getText();
   Assert.assertEquals(levisProductTest,"Levis Mens Regular Fit Tee");
    System.out.println("the product is added to cart");
    ac.buyNowButtonInAddToCartPage().click();
     String addresPageUrl = driver.getCurrentUrl();
     Assert.assertEquals(addresPageUrl,"https://www.shoppersstack.com/selectaddress");
     System.out.println("the address page is displayed"); 
    
    Addresspage ap= new   Addresspage (driver);
     ap.getlovwebirdAddress().click();
     ap.getprocedButton().click();
     
     Paymentmethod pm=new Paymentmethod(driver);
     pm.getcashOndeliveryRadioButton().click();
     pm.getProceedButton().click();
     
     Orderconfirmpage oc=new Orderconfirmpage(driver);
     
     Assert.assertEquals(oc.getOrderConfirmedText().getText(),"Order Confirmed");
     System.out.println("The order got confiremed in cash on delivery");
	}

	@Test(priority=2,dependsOnMethods="Tc_AddAddress_001_Test")
	public void EndToEnd_NetBanikng() throws Throwable {
		Thread.sleep(3000);
	    System.out.println("first test case");
	    String titleHomePage=driver.getTitle();
	    Assert.assertEquals(titleHomePage,"ShoppersStack | Home"); 
	    Homepage hp=new Homepage(driver);
	    Thread.sleep(5000);
	    WebElement menLink=hp.getmenMenuLink(); 
	    wu.mouseOverAction(driver,menLink);  
	    hp.getTshirtPopupLink().click();  
	    Tshirtpage tsp=new  Tshirtpage(driver);
	String currentUrl=driver.getCurrentUrl();
	  Assert.assertEquals(currentUrl,"https://www.shoppersstack.com/sub-category/men-tshirt"); 
	  wu.mouseOverAction(driver,tsp.gettshirtTopLink());
	    tsp.gettlevisMensRegularfitproduct_AddTOCartButton().click();    hp.getaddToCartLink().click();
	   Assert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/cart"); 
	    System.out.println("The cart page has opened");
	   
	    Addtocartpage ac=new Addtocartpage(driver);
	   String levisProductTest= ac.getlevisProduct().getText();
	   Assert.assertEquals(levisProductTest,"Levis Mens Regular Fit Tee");
	    System.out.println("the product is added to cart");
	    ac.buyNowButtonInAddToCartPage().click();
	     String addresPageUrl = driver.getCurrentUrl();
	     Assert.assertEquals(addresPageUrl,"https://www.shoppersstack.com/selectaddress");
	     System.out.println("the address page is displayed"); 
	    
	     Addresspage ap= new  Addresspage(driver);
	     ap.getlovwebirdAddress().click();
	     ap.getprocedButton().click();
//	     Paymentmethod pm=new Paymentmethod(driver);
//	    WebElement netbankingbutton= pm.getNetBankingButton();
//	    wu.javaScriptClick(driver,netbankingbutton);
//	    
//	     pm.getProceedButton().click();
//	     Netbankingpage nb= new Netbankingpage(driver);
//	     driver.switchTo().frame(nb.getnetBankingFrameTag());
//	     
//	     nb.getIDHC_radioButton().click();
//	     nb.getsubmitButton().click();
//	     driver.switchTo().defaultContent();
//	     
	     
	}
	

	//public void  Tc_AddToCart_001_Test1() throws Throwable {
			//System.out.println("login...........");
			//Thread.sleep(5000l);
			//System.out.println("first test case");
			//String titleHomepage = driver.getTitle();
			//Assert.assertEquals(titleHomepage, "ShoppersStack|Home");
			//Homepage hp = new Homepage(driver);
			//Thread.sleep(5000l);

		//}
	
		
		//public void  Tc_AddToCart_001_Test2() throws Throwable {
			//Thread.sleep(5000l);
				//System.out.println("ssecond test case");
		}
	

