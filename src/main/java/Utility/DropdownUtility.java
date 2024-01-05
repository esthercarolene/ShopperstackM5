package Utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtility {
public void selectDropDownByVisibleText(String textofOption, WebElement selectTagOfDropDown) {
	Select select=new Select(selectTagOfDropDown);
	select.selectByVisibleText(textofOption);
	
}
public void selectDropDownByValueattributeValue(String ValueattributeValue, WebElement selectTagOfDropDown ) {
	Select select=new Select(selectTagOfDropDown);
	select.selectByValue(ValueattributeValue);

}
public void selectDropDownByIndex(int Index, WebElement selectTagOfDropDown ) {
	Select select=new Select(selectTagOfDropDown);
	select.selectByIndex(Index);
}
public void DeslectDropDownByVisibleText(String textofOption, WebElement selectTagOfDropDown) {
	Select select=new Select(selectTagOfDropDown);
	select.deselectByVisibleText(textofOption);
	
}
public void DeselectDropDownByValueattributeValue(String ValueattributeValue, WebElement selectTagOfDropDown ) {
	Select select=new Select(selectTagOfDropDown);
	select.deselectByValue(ValueattributeValue);

}
public void DeselectDropDownByIndex(int Index, WebElement selectTagOfDropDown ) {
	Select select=new Select(selectTagOfDropDown);
	select.deselectByIndex(Index);
}
public ArrayList dropdown(WebElement selectTagOfDropDown) {
	Select select=new Select(selectTagOfDropDown);
List<WebElement> allOptions = select.getOptions();
ArrayList<String> allOptionsText = new ArrayList<>();
for(WebElement ele:allOptions) {
	allOptionsText.add(ele.getText());
}
return allOptionsText;
}
public WebElement ToGetParticularOptionIndex(WebElement selectTagOfDropDown, int indexofOption) {
	Select select=new Select(selectTagOfDropDown);
List<WebElement> allOptions = select.getOptions();
WebElement particularOptionWebElement=allOptions.get(indexofOption);
return particularOptionWebElement;
}

}
