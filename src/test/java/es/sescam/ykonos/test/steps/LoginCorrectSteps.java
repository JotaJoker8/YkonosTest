package es.sescam.ykonos.test.steps;

import cucumber.api.java.en.*;
import es.sescam.ykonos.test.pages.LoginCorrectPage;

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
    public void clickAccessButton(){
        login.clickAccessButton();
    }

    @Then("^User (.+) with password (.+) enter in the Sescam app$")
    public void enterSescamApp(String correctUser, String correctPassword){
        login.validateCorrectLogin(correctUser, correctPassword);
    }

}