package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver dr;    //Every class have own private webdriver and referance we will create for hold driver in veriable.
	
	//1.Locators:
	private By EmailId = By.id("email");
	private By PasswodId = By.id("passwd");
	private By SignInButton = By.id("SubmitLogin");
	private By LinkText = By.linkText("Forgot your password?111");
	
	//2.Constructor Of the page
	public LoginPage(WebDriver wdr){     //for Constructor need webdriver and give webdriver to private webdriver.
	    this.dr = wdr;
		
	}
	
	//3.Page actions: Features (Behaviour) of the page the form of method.
	
	public String getLoginPageTitle(){
		return dr.getTitle();
	}
	
	public Boolean chkForgetPasswordLink(){
		
		return dr.findElement(LinkText).isDisplayed();
	}
	
	public void enterUserName(String username){
		dr.findElement(EmailId).sendKeys(username);
	}
	
	public void enterPassword(String Password){
		dr.findElement(PasswodId).sendKeys(Password);
	}
	
	public void clikSignIn(){
		dr.findElement(SignInButton).click();
	}
	
	public AccountsPage dologin(String un, String pwd){             //This method for login combine use for any scenario.
		
		System.out.println("Entered username = " + un + " and Entered password " + pwd); 
		dr.findElement(EmailId).sendKeys(un);
		dr.findElement(PasswodId).sendKeys(pwd);
		dr.findElement(SignInButton).click();
		return new AccountsPage(dr);
	}

	
	
}
