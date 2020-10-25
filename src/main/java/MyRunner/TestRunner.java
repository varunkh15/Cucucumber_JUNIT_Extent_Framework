   package MyRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.cucumber.listener.Reporter;


	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "C:\\Users\\varun\\Desktop\\Selenium\\CucumberSeleniumFramework-master\\src\\main\\java\\Features\\taggedhooks.feature", //the path of the feature files
			glue={"stepDefinitions"}, //the path of the step definition files
			format= {"pretty","html:test-outout","json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
			//to generate different types of reporting
			plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html","json:output/cucumber.json"},
			monochrome = true, //display the console output in a proper readable format
			strict = true //it will check if any step is not defined in step definition file
			//dryRun = true //to check the mapping is proper between feature file and step def file
			//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}			
			)
	 
	public class TestRunner {
		
		@AfterClass
		public static void teardown() {

			Reporter.loadXMLConfig(new File("C:\\Users\\varun\\Desktop\\Selenium\\CucumberSeleniumFramework-master\\configs\\extent-config.xml"));
			Reporter.setSystemInfo("user", System.getProperty("user.name"));
			Reporter.setSystemInfo("os", "Windows 10");
			Reporter.setTestRunnerOutput("Sample test runner output message");
		}
	 
	}
	
	//ORed : tags = {"@SmokeTest , @RegressionTest"} -- execute all tests tagged as @SmokeTest OR @RegressionTest
	//ANDed : tags = tags = {"@SmokeTest" , "@RegressionTest"} -- execute all tests tagged as @SmokeTest AND @RegressionTest
	

