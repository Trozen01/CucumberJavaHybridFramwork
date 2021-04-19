package StepDefiniation;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {

	public static String Tital;           // we declare static because if we declare static then we don't need to declare object of class and veriable.
	private LoginPage lp = new LoginPage(DriverFactory.getdriver());
	private AccountsPage ap;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable crdTable) {
	 
	       List<Map<String, String>> crdlist = crdTable.asMaps();
	       String un =crdlist.get(0).get("username");
	       String pw =crdlist.get(0).get("password");
	       DriverFactory.getdriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");   // first we need to go this URL.
	       ap = lp.dologin(un, pw);
	  
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	        String title = ap.getAccountsPageTitle();
	        System.out.println("Accounts page Title is: " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable SectionTable) {
	   
	   List<String> ExpectedAccountSectionlist = SectionTable.asList();
	   System.out.println("Expected Account Section list: " + ExpectedAccountSectionlist);
	   
	   List<String> ActualAccountSectionlist = ap.getAccountSectionlist();
	   System.out.println("Actual Account list:= " + ActualAccountSectionlist);
	   
	   Assert.assertTrue(ExpectedAccountSectionlist.containsAll(ActualAccountSectionlist));   //compare two list.
	
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(int ExpectedSectioncount) {
	    Assert.assertTrue(ap.getAccountSectionCount() == ExpectedSectioncount);   // checking account section count.
	}
}
