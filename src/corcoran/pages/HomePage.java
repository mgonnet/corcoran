package corcoran.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import corcoran.framework.SeleniumUtils;

public class HomePage extends BasePage{
	
	@FindBy(how = How.CSS, using = "span.secondary-btn.Primary-Color")
	private WebElement searchInput;	
	
	@FindBy(how = How.CLASS_NAME, using = "FormTrigger")
	private WebElement seeResults;	
	
	@FindBy(how = How.CLASS_NAME, using = "ui-slider-handle")
	private WebElement priceSlider;	
	
	@FindBy(how = How.ID, using = "price-slider")
	private WebElement priceSlideBar;		
	
	public HomePage(WebDriver driver){
		super(driver);		
	}
	
	public ResultsPage filterByLocationAndPrice(String location) throws InterruptedException{
		
		Actions move = new Actions(driver);
        Action action = (Action) move.dragAndDropBy(priceSlider, priceSlideBar.getSize().width*10/40, 0).build();
        action.perform();
                        
		searchInput.click();					
		clickLocation(location);								
		seeResults.click();	
		
		return new ResultsPage(driver);
	}
	
	private void clickLocation(String location){
		String locationXpathLocator = "//span[contains(text(), '" + location + "')]";
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locationXpathLocator)));
		
		WebElement locationSpan = driver.findElement(By.xpath(locationXpathLocator));

		WebElement locationSubmit = driver.findElement(By.id(locationSpan.getAttribute("for")));
		locationSubmit.click();
	}
}
