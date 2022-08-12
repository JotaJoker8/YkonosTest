package es.sescam.ykonos.test;

import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import es.sescam.ykonos.test.constants.ConstantClass;
import es.sescam.ykonos.test.testlink.TestLinkIntegration;
import es.sescam.ykonos.test.util.Order;
import es.sescam.ykonos.test.util.OrderedRunner;
import es.sescam.ykonos.test.util.TestDataUtil;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

@RunWith(OrderedRunner.class)
public class TestDataIntegration {
	
	protected static WebDriver driver;
	private static WebDriverWait wait;
	private static Configuration config;
	
	private WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
	
	public void write(String locator, String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }
	
	public void clickElement(String locator){
        find(locator).click();
    }
	
	public void clickDetailsButton(){
        clickElement(config.getString("config-data.details-button"));
    }

    public void clickAccessUrl(){
        clickElement(config.getString("config-data.access-url"));
    }
	
	public void writeUserPassword(){
        write(config.getString("config-data.user-value"), config.getString("config-data.user-name"));
        write(config.getString("config-data.password-value"), config.getString("config-data.password"));
    }
	
	public void clickAccessButton(){
		clickElement(config.getString("config-data.access-button"));
	}
	
	public void userValidate(String userName){
       Assert.assertEquals(userName, config.getString("test-data.user-password-correct"));
    }
	
	public void compareInputs() throws TestLinkAPIException, ConfigurationException{
		if(config.getString("config-data.user-name").equals(config.getString("test-data.user-password-correct")) 
			&& config.getString("config-data.password").equals(config.getString("test-data.user-password-correct"))) {
			TestLinkIntegration.updateResults(config.getString("tests.test-case-1"), null, TestLinkAPIResults.TEST_PASSED);
		}else{
			TestLinkIntegration.updateResults(config.getString("tests.test-case-1"), "Usuario " + config.getString("config-data.user-name") 
			+ " Password " + config.getString("config-data.password"), TestLinkAPIResults.TEST_FAILED);
		}
    }
	
	@BeforeClass
	public static void openBrowser() throws ConfigurationException {
		config = TestDataUtil.loadTestsData(ConstantClass.TEST_DATA_PATH);
		System.setProperty(config.getString("test-data.chrome-driver"), config.getString("test-data.chrome-driver-route"));
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, config.getInt("config-data.explicit-wait"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(config.getInt("config-data.implicit-wait"), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	@Order(0)
	public void validLogin() throws TestLinkAPIException, ConfigurationException {
		driver.get(config.getString("config-data.url"));
		clickDetailsButton();
		clickAccessUrl();
		writeUserPassword();
		clickAccessButton();
		compareInputs();
	}
	
}
