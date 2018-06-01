package corcoran.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtils {

	/**
     * Wait for an element to be present and visible
     * 
     * @param driver
     * @param byLocator
     * @param seconds max seconds to wait for element to present and be visible
     */
    public static Boolean waitForElementToBeVisible(WebDriver driver, final By byLocator, int seconds) throws InterruptedException {

        for (int second = 0; second < seconds; second++) {
            try {
                if (driver.findElement(byLocator).isDisplayed()) {
                    return Boolean.TRUE;
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                Thread.sleep(1000);
            }
        }
        
        return Boolean.FALSE;
    }
}
