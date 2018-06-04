package corcoran;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import corcoran.pages.HomePage;
import corcoran.pages.PropertyPage;
import corcoran.pages.ResultsPage;

@RunWith(Parameterized.class)
public class SearchApartmentTest {

	private WebDriver driver;
	
	private String location;
	
	@Parameters
    public static Iterable data(){
        return Arrays.asList(new Object[][]{
                {"Flatiron"}
        });
    }
	
	public SearchApartmentTest(String location){
		this.location=location;
	}
	
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
		System.out.println("Search apartment above 800000 in flatiron");
		Integer price = 800000;
		
		HomePage homePage = new HomePage(driver);
		ResultsPage resultsPage = homePage.filterByLocationAndPrice(location);
		PropertyPage propertyPage = resultsPage.selectFirstListing();
		
		int propertyPrice = propertyPage.getPropertyPrice();
		boolean priceGraterThan = propertyPrice >= price;

		System.out.println("-> " + propertyPrice + " > " + price + "? - " + priceGraterThan);
		assertTrue(priceGraterThan);		
	}

}
