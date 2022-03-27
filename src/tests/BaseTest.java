package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import messages.Login;
import messages.URL;
import pages.BasePage;
import testData.TestData;
import testData.User;

public class BaseTest {
	static WebDriver driver;
	BasePage page;
	
	User mainUserTestData = new User("mainUser");
	TestData testData = new TestData();
	
	@BeforeClass
	public static void beforeAll() {
		
	}
	
	@AfterClass
	public static void afterAll() {
		
	}
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		page = new BasePage(driver);
		driver.navigate().to(URL.LOGIN);
//		page.login.authenticate(testData.mainUser);
//		Assert.assertEquals(URL.PRODUCTS,driver.getCurrentUrl());
	}
	
	@After
	public void after() {
		driver.close();
		driver.quit();
	}

}
