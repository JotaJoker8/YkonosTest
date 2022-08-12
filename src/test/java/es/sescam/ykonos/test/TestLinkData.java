package es.sescam.ykonos.test;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.BasicConfigurationBuilder;
import org.apache.commons.configuration2.builder.ConfigurationBuilder;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.FileHandler;

public class TestLinkData {
	
	private TestLinkData() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}

	public static Configuration loadTestsData() throws ConfigurationException {

		ConfigurationBuilder<XMLConfiguration> testsDataConfigurationBuilder = new BasicConfigurationBuilder<>(XMLConfiguration.class);

		XMLConfiguration testsDataConfiguration = testsDataConfigurationBuilder.getConfiguration();

		FileHandler testsDataFileHandler = new FileHandler(testsDataConfiguration);
		testsDataFileHandler.load(TestLinkData.class.getResourceAsStream("/config/tests-link-data.xml"));

		return testsDataConfiguration;

	}
}
