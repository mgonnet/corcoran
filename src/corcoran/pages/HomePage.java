package corcoran.pages;

import org.openqa.selenium.By;
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
	
	@FindBy(how = How.ID, using = "price-slider")
	private WebElement priceSlideBar;		
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public ResultsPage filterByLocation(String location) throws InterruptedException{
		
		Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(priceSlider, priceSlideBar.getSize().width*7/40, 0).build();
        action.perform();
        
		searchInput.click();	
		System.out.println("Waiting for flatiron");
		SeleniumUtils.waitForElementToBeVisible(driver, By.id("Borough1Neighborhood39"), 15);
		flatiron.click();				        
		seeResults.click();	
		
		return new ResultsPage(driver);
	}
}
