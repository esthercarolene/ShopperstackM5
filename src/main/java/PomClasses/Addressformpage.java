package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addressformpage {
	public WebDriver driver;
	public Addressformpage (WebDriver driver){
		PageFactory.initElements(driver,this);
	}		
	@FindBy(id="Name")
	private WebElement nameTF;
	
	public WebElement getnameTF() {
		return nameTF;
	}
	 @FindBy(id="House/Office Info")
	 private WebElement houseofofficeTF;
	 
	 public WebElement gethouseofofficeTF() {
		 return houseofofficeTF;
	 }
	 
	 @FindBy(id="Street Info")
	 private WebElement streetinfoTF;
	 
	 public WebElement getstreetinfoTF() {
		 return streetinfoTF;
	 }
	 
	 @FindBy(id="Landmark")
	 private WebElement landmarkTF;
	 
	 public WebElement getlandmarkTF() {
		 return landmarkTF;
	 }
	 
	 @FindBy(id="Country")
	 private WebElement countryTFDropDown;
	 
	 public WebElement getcountryTFDropDown() {
		 return countryTFDropDown;
	 }
	 
	 @FindBy(id="State")
	 private WebElement stateDropDown;
	 
	 public WebElement getstateDropDown() {
		 return stateDropDown;
	 }
		
		@FindBy(id="City")
		private WebElement cityDropDown;
		
		public WebElement getcityDropDown() {
			return cityDropDown;
		}
		
		@FindBy(id="Pincode")
		private WebElement pincodeTF;
		
		public WebElement getpincodeTF() {
			return pincodeTF;
		}
		
		@FindBy(id="Phone Number")
private WebElement phonenumberTF;
		
		public WebElement getphonenumberTF() {
			return phonenumberTF;
		}
		
		@FindBy(xpath="//button[text()='Add Address']")
		private WebElement addaddressButton;
		
		public WebElement getaddaddressButton() {
			return addaddressButton;
		}
		
		
		
		
		
		
		
		

}