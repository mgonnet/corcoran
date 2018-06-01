package corcoran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import corcoran.framework.SeleniumUtils;

public class ResultsPage {

	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[7]/div[1]/div[1]/div/span[3]")
	private WebElement searchResults;
	
	@FindBy(how = How.CSS, using = "div.address")
	private WebElement firstListing;
	
	public ResultsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void selectFirstListing() throws InterruptedException{
		System.out.println("SelectFirstListing");
		
		SeleniumUtils.waitForElementToBeVisible(driver, By.xpath("/html/body/div[7]/div[1]/div[1]/div/span[3]"), 15);
		firstListing.click();
	}
	
}
