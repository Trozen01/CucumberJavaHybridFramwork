package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// this class is created for Rerun failler test cases first you run MyTestRunner then failedrerun.txt file will generated then then come here and run FailedRun.java    

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty","html:target/HtmlReport/report.html",
                "junit:target/JunitReport/report.xml",
                "json:target/JsonReport/report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failedrerun.txt"      // It will make a entry of that perticular scenario in txt file.
},	
		
		glue={"StepDefiniation","AppHooks"},
		monochrome=true,                                     // if this option is true then all console line is come in black format.
		features={"@target/failedrerun.txt"}	
		)
public class FailedRun {

}
