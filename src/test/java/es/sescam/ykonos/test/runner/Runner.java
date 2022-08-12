package es.sescam.ykonos.test.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//import org.junit.runners.Suite.SuiteClasses;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import es.sescam.ykonos.test.TestDataIntegration;
import es.sescam.ykonos.test.pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features"},
    glue = {"es.sescam.ykonos.test.steps"},
    // plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
    plugin = {"pretty", "junit:target/cucumber-reports/cucumber.xml"}, 
    // plugin = {"pretty","json:target/cucumber-reports/Cucumber.json"},
    // plugin = {"pretty","html:target/cucumber-reports"},
    // plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
	// 		"junit:target/cucumber-reports/Cucumber.xml",
	// 		"html:target/cucumber-reports"},
    tags = {"@Test1"}
)

/*@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestDataIntegration.class
})*/

public class Runner {
	
	private Runner() {}
	
    @AfterClass
    public static void clearDriver(){
        BasePage.closeBrowser();
    }
}
