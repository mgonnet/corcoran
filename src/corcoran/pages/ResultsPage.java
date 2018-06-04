package corcoran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import corcoran.framework.SeleniumUtils;

public class ResultsPage extends BasePage {
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'SEARCH RESULTS')]")
	private WebElement searchResults;
	
	@FindBy(how = How.CLASS_NAME, using = "address")
	private WebElement firstListing;
	
	public ResultsPage(WebDriver driver){
		super(driver);		
	}
	
	public PropertyPage selectFirstListing() throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(searchResults));
		
		firstListing.click();
		
		return new PropertyPage(driver);
	}
	
}
