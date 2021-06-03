package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:/Jitu/Work/SoftwareTesting/Practical/CucumberJavaHybridFramwork/src/test/resources/AppFeatures/LoginPage.feature",
		glue={"StepDefiniation","AppHooks"},
		monochrome=true,                                         // if this option is true then all console line is come in black format.
		//tags ="not @Skip",                                     // it will use for not execute particular scenario. 
		plugin={"pretty","html:target/HtmlReport/report.html",
		                 "junit:target/JunitReport/report.xml",
		                 "json:target/JsonReport/report.json",
		                 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",    // it generate cucumber spark report.html
		                 "rerun:target/failedrerun.txt"      // It will make a entry of that particular scenario in txt file which scenario is failed. may be because internet issue and time issue etc. 
		}		
		)
public class MyTestRunner {

}
