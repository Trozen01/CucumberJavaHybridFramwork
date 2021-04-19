package StepDefiniation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactusPageSteps {
	
	private ContactUsPage cup = new ContactUsPage(DriverFactory.getdriver()); // it will use for lunch the browser and hear we call all method from login page but login have constructor and
                                                                                    	//constructor want webdriver so we provide DriverFactory class and method.
	
	@Given("user Nevigate to contact us page")
	public void user_nevigate_to_contact_us_page() {
		
		DriverFactory.getdriver().get("http://automationpractice.com/index.php?controller=contact");
		
		String PageTitle = cup.getContactUsPageTitle();
		System.out.println("Contact us page Title is:-" + PageTitle);
	  
	}
	
	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("C:/Jitu/Work/SoftwareTesting/Practical/CucumberJavaHybridFramwork/Data/AutomationData.xlsx", Sheetname);
		
	    String heading = testData.get(rownumber).get("subjectheadline");    // write column name as key and code autometicly fatch the value from excelsheet.
		String email = testData.get(rownumber).get("email");
		String orderRef = testData.get(rownumber).get("orderref");
		String message = testData.get(rownumber).get("message");
		
		System.out.println("Message is = " +message);
		
		cup.fillCotactUsForm(heading, email, orderRef, message);
	  
	}

	@When("user click on send button")
	public void user_click_on_send_button() {
		cup.clickSend();
	}

	@Then("It shows a message as {string}")
	public void it_shows_a_message_as(String expSuccessMessage) {
		String actualSuccMessg = cup.getSuccessMessg();
		Assert.assertEquals(actualSuccMessg, expSuccessMessage); 
	}

}
