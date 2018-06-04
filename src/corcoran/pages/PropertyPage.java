package corcoran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PropertyPage {

	private WebDriver driver;
	
	@FindBy(how = How.CLASS_NAME, using = "listing-price")
	private WebElement price;
	
	public PropertyPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public Integer getPropertyPrice(){
		String strPrice = price.getText().trim();
		strPrice = strPrice.replaceAll("[^\\d.]", "");
		return Integer.valueOf(strPrice);
	}
	
}
