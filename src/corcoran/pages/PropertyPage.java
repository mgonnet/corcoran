package corcoran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PropertyPage extends BasePage{
	
	@FindBy(how = How.CLASS_NAME, using = "listing-price")
	private WebElement price;
	
	public PropertyPage(WebDriver driver){
		super(driver);
	}
	
	public Integer getPropertyPrice(){
		String strPrice = price.getText().trim();
		strPrice = strPrice.replaceAll("[^\\d.]", "");
		return Integer.valueOf(strPrice);
	}
	
}
