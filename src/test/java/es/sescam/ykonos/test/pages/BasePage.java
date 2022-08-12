package es.sescam.ykonos.test.pages;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import es.sescam.ykonos.test.constants.ConstantClass;
import es.sescam.ykonos.test.util.TestDataUtil;

public class BasePage {
    
	protected BasePage() {}
	
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Configuration config;
	
	static{
		try {
			config = TestDataUtil.loadTestsData(ConstantClass.TEST_DATA_PATH);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		System.setProperty(config.getString("test-data.chrome-driver"), config.getString("test-data.chrome-driver-route"));
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, config.getInt("config-data.explicit-wait"));
    }
    
    public void navigateToYkonosApp(){
        driver.get(config.getString("config-data.url"));
    }
    
    public boolean accessButtonIsEnabled(){
        return find(config.getString("config-data.access-button")).isEnabled();
    }

    public WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected String getProperty(String keyProperty) {
    	return config.getString(keyProperty);
    }
    
    public void writeUserPassword(String user, String password){
    	find(getProperty("config-data.user-value")).clear();
        find(getProperty("config-data.user-value")).sendKeys(user);
    	find(getProperty("config-data.password-value")).clear();
        find(getProperty("config-data.password-value")).sendKeys(password);
    }
    
    public void clickAccessButton(){
        find(getProperty("config-data.access-button")).click();
    }

    public static void closeBrowser(){
        driver.quit();
    }

}
