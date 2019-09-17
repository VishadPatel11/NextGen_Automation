package testRunner;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
//import com.cucumber.listener.Reporter;
import managers.FileReaderManager;

import java.io.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "//Users//vipatel//NextGen_Automation//Features//SqspLogin.feature"          //to map to the script
        ,glue = "stepDefinition"      //to map to the methods
        //,dryRun= true			   // to just make sure steps have methods
        //,monochrome = false			 	//displays details of time elapsed in tests
        //,format = { "html:Desktop"}		//display results in html,json,xml
        //,format = {"json:Desktop/cucumber.json"}
        //,format = { "junit:Desktop/cucumber.xml"}
        //,strict = true 					//fail the execution if there is any undefined steps or pending steps
        ,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html"}
)

public class TestRunner {
    @AfterClass
    public static void writeExtentReport() throws IOException {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Mac OS" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
        Reporter.assignAuthor("Vishad Patel");
        Reporter.addScreenCaptureFromPath("target/cucumber-reports/report.html");


    }
}

