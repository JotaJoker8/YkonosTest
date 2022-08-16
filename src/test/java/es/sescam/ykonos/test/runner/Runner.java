package es.sescam.ykonos.test.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import es.sescam.ykonos.test.pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features"},
    glue = {"es.sescam.ykonos.test.steps"},  
    plugin = {"pretty", "junit:target/cucumber-reports/cucumber.xml"}, 
    tags = {"@Test"}
)

public class Runner {
	
	private Runner() {}
	
    @AfterClass
    public static void clearDriver(){
        BasePage.closeBrowser();
    }
}
