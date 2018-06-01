package corcoran;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import corcoran.pages.HomePage;
import corcoran.pages.ResultsPage;

public class SearchApartmentTest {

	private WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.get("https://www.corcoran.com/");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		ResultsPage resultsPage = homePage.filterByLocation("");
		resultsPage.selectFirstListing();
	}

}
