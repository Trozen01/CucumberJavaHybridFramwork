package AppHooks;

import java.util.Properties;

//import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory df;       // This is private method because we not use this in any other class.It used for lunch the browser.
	private WebDriver wd;          // initalise browser
	private ConfigReader cr;    // Read config.property file.
	Properties prop;
	
	/*@Before(value="@Skip", order=0)                      // This hooks we use for skip the scenario and set order as 0. This is second method to skip the scenario.
	public void skip_scenario(Scenario sc){
		System.out.println("Skiped scenario is:-" +sc.getName());
		Assume.assumeTrue(false);
	}*/
	
	
	@Before(order = 1)
	public void getProperty(){
		cr = new ConfigReader();      // create object of the ConfigReader class.
		prop =cr.init_prop();         // call init_prop method from ConfigReader class and it will returm property value and store in prop.
	}
	
	@Before(order = 2)
	public void lunchBrowser(){
		String browsername =prop.getProperty("browser");  // using this method we get data from config.properties 
		df = new DriverFactory();     // we need to create object of the DriverFactory for call the method of driverfactory and lunch the browser
		wd = df.init_driver(browsername);
		}
	
	@After(order = 0)
	public void quitBrowser(){
		wd.quit();
}
	
	
	@After(order = 1)
	public void tearDown(Scenario sc){
		System.out.println("Screenshot process start");
		
		if(sc.isFailed()){
             String schreenshotname =sc.getName().replaceAll("", "_");
             byte[] sourcepath = ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
             sc.attach(sourcepath, "image/png", schreenshotname);
		}
	}
}





