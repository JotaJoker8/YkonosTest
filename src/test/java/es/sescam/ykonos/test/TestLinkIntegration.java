package es.sescam.ykonos.test;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {
	
	private TestLinkIntegration() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}
	
	public static void updateResults(String testCaseName, String exception, String results) throws TestLinkAPIException, ConfigurationException {
		Configuration config = TestLinkData.loadTestsData();
		TestLinkAPIClient testlink = new TestLinkAPIClient(config.getString("test-link-data.test-link-key"),
				config.getString("test-link-data.test-link-url"));
		testlink.reportTestCaseResult(config.getString("test-link-data.test-project-name"),
				config.getString("test-link-data.test-plan-name"), testCaseName,
				config.getString("test-link-data.test-build-name"), exception, results);
	}
	
}
