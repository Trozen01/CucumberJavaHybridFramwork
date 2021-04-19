package StepDefiniation;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

   public static String Tital;           // we declare static because if we declare static then we don't need to declare object of class and veriable.
	private LoginPage lp = new LoginPage(DriverFactory.getdriver());  // it will use for lunch the browser and hear we call all method from login page but login have constructor and
                                                        	//constructor want webdriver so we provide DriverFactory class and method. 
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		DriverFactory.getdriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    
	}

	@When("user gets the title of the page")           // this method is use for two step from feature file.
	public void user_gets_the_title_of_the_page() {
	    Tital =lp.getLoginPageTitle();
		 System.out.println("Tital of the page is:= " +Tital);
	}

	@Then("page title should be {string}")             // this method is use for two step from feature file.
	public void page_title_should_be(String ExptTitle) {
		Assert.assertEquals("Tital of the is from code:-", Tital, ExptTitle);
		
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	    Assert.assertTrue(lp.chkForgetPasswordLink());
	}

	@When("user enters username {string}")
	public void user_enters_username(String uName) {
	     lp.enterUserName(uName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pName) {
		 lp.enterPassword(pName);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
      lp.clikSignIn();
	}

	
}
