package es.sescam.ykonos.test.pages;

import org.junit.Assert;

public class LoginCorrectPage extends BasePage {

	public void clickDetailsButton(){
        find(getProperty("config-data.details-button")).click();
    }
    
    public void clickAccessUrl(){
    	find(getProperty("config-data.access-url")).click();
    }
    
    public void validateCorrectLogin(String user, String password) {
    	Assert.assertEquals((getProperty("config-data.user-name")), user);
    	Assert.assertEquals((getProperty("config-data.password")), password);
    }
}