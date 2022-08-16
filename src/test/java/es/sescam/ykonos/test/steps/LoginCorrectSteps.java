package es.sescam.ykonos.test.steps;

import org.apache.commons.configuration2.ex.ConfigurationException;

import cucumber.api.java.en.*;
import es.sescam.ykonos.test.pages.LoginCorrectPage;
import testlink.api.java.client.TestLinkAPIException;

public class LoginCorrectSteps {
    
    LoginCorrectPage login = new LoginCorrectPage();
    
    @Given("^I navigate to the Sescam app$")
    public void navigateToSescamApp(){
        login.navigateToYkonosApp();
        login.clickDetailsButton();
        login.clickAccessUrl();
    }

    @And("^Access button is disabled$")
    public void buttonIsEnabled(){
        login.accessButtonIsEnabled();
    }

    @When("^Write (.+) and (.+)$")
    public void enterUserPassword(String correctUser, String correctPassword){
        login.writeUserPassword(correctUser, correctPassword);
    }

    @And("^Click on the access button$")
    public void clickAccessButton() throws TestLinkAPIException, ConfigurationException{
        login.clickAccessButton();
        login.validateCorrectLogin();
    }

    @Then("^User enter in the Sescam app$")
    public void enterSescamApp(){
        login.navigateToWelcomeUrl();
    }

}