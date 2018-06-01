package corcoran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import corcoran.framework.SeleniumUtils;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(how = How.CSS, using = "span.secondary-btn.Primary-Color")
	private WebElement searchInput;
	
	@FindBy(how = How.ID, using = "Borough1Neighborhood39")
	private WebElement flatiron;
	
	@FindBy(how = How.XPATH, using = "(//button[@type='submit'])[5]")
	private WebElement seeResults;	
	
	@FindBy(how = How.XPATH, using = "//div[@id='price-slider']/span")
	private WebElement priceSlider;	
		
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void filterByLocation(String location) throws InterruptedException{
		SeleniumUtils.waitForElementToBeVisible(driver, searchInput, 10);
		searchInput.click();
		
		SeleniumUtils.waitForElementToBeVisible(driver, flatiron, 10);
		flatiron.click();
		
		Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(priceSlider, 50, 0).build();
        action.perform();
        
        SeleniumUtils.waitForElementToBeVisible(driver, seeResults, 10);
		seeResults.click();			
	}
}
