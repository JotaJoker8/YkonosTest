package es.sescam.ykonos.test.pages;

import org.apache.commons.configuration2.ex.ConfigurationException;

import es.sescam.ykonos.test.testlink.TestLinkIntegration;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class LoginCorrectPage extends BasePage {

	public void clickDetailsButton(){
        find(getProperty("config-data.details-button")).click();
    }
    
    public void clickAccessUrl(){
    	find(getProperty("config-data.access-url")).click();
    }
    
    public void navigateToWelcomeUrl() {
    	driver.get(config.getString("config-data.welcome-url"));
    }
    
    public void validateCorrectLogin() throws TestLinkAPIException, ConfigurationException{
		if(config.getString("config-data.correct-user").equals(config.getString("test-data.user-password-correct")) 
			&& config.getString("config-data.correct-password").equals(config.getString("test-data.user-password-correct"))) {
			TestLinkIntegration.updateResults(config.getString("tests.test-case-1"), null, TestLinkAPIResults.TEST_PASSED);
		}else{
			TestLinkIntegration.updateResults(config.getString("tests.test-case-1"), "Usuario " + config.getString("config-data.correct-user") 
			+ " Password " + config.getString("config-data.correct-password"), TestLinkAPIResults.TEST_FAILED);
		}
    }
}