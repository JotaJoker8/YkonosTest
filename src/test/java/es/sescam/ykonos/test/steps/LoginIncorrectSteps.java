package es.sescam.ykonos.test.steps;

import cucumber.api.java.en.*;
import es.sescam.ykonos.test.pages.BasePage;
import es.sescam.ykonos.test.pages.LoginIncorrectPage;

public class LoginIncorrectSteps extends BasePage {
    
    LoginIncorrectPage login = new LoginIncorrectPage();
    
    @Given("^Navigate to the app$")
    public void navigateToSescamApp(){
        login.navigateToYkonosApp();
        login.accessButtonIsEnabled();
    }

    @When("^Enter (.+) and (.+) incorrect$")
    public void enterUserPassword(String incorrectUser, String incorrectPassword){
        login.writeUserPassword(incorrectUser, incorrectPassword);
    }

    @And("^User (.+) with password (.+) makes click on the access button$")
    public void clickAccess(String incorrectUser, String incorrectPassword){
        login.clickAccessButton();
        login.validateIncorrectLogin(incorrectUser, incorrectPassword);
    }

    @Then("^It shows login error message$")
    public void enterSescamApp(){
        login.findErrorMessage();
    }

    @And("^Recover contents of message$")
    public void bringContainMessage(){
        login.compareTextErrorMessage1();
        login.compareTextErrorMessage2();
    }

    @And("^Input border is red$")
    public void confirmBorderColorInput(){
        login.confirmInputColor();
    }
}