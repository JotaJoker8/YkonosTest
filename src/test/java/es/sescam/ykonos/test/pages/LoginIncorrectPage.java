package es.sescam.ykonos.test.pages;

import org.apache.commons.configuration2.ex.ConfigurationException;

import es.sescam.ykonos.test.testlink.TestLinkIntegration;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class LoginIncorrectPage extends BasePage {

    public boolean findErrorMessage(){
        return find(getProperty("config-data.error-message")).isDisplayed();
    }

    public boolean compareTextErrorMessage1(){
        return getProperty("config-data.error-message-1") != null &&
        		getProperty("config-data.error-message-1").equals("Error en la autenticación del usuario");
    }    

    public boolean compareTextErrorMessage2(){
        return getProperty("config-data.error-message-2") != null &&
        		getProperty("config-data.error-message-2").equals("Usuario o contraseña incorrectos");
    }

    public boolean confirmInputColor(){
        return getProperty("config-data.password-value") != null && getProperty("config-data.password-value").equals("#dc3545");
    }
    
    public void validateIncorrectLogin(String user, String password) throws TestLinkAPIException, ConfigurationException{
		if(!getProperty("config-data.incorrect-user").equals(getProperty("test-data.user-password-correct")) 
			&& !getProperty("config-data.incorrect-password").equals(getProperty("test-data.user-password-correct"))) {
			TestLinkIntegration.updateResults(getProperty("tests.test-case-1"), null, TestLinkAPIResults.TEST_PASSED);
		}else{
			TestLinkIntegration.updateResults(getProperty("tests.test-case-1"), "Usuario " + getProperty("config-data.incorrect-user") 
			+ " Password " + getProperty("config-data.incorrect-password"), TestLinkAPIResults.TEST_FAILED);
		}
    }
}