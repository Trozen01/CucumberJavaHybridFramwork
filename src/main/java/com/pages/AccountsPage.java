package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver dr;
	
	//1.Locators:
	private By accountsection = By.cssSelector("div#center_column span"); 
	
	//2.Constructor Of the page
	public AccountsPage(WebDriver wdr){     //for Constructor need webdriver and give webdriver to private webdriver(value come from different pagewebdrivefr to this page's webdriver).
	    this.dr = wdr;
		
	}
	
	public String getAccountsPageTitle(){
		return dr.getTitle();
	}
	
	public int getAccountSectionCount (){                  // this method is give you size of the account list.
		return dr.findElements(accountsection).size();
	}
	
	public List<String> getAccountSectionlist(){                //this method is use for get all accountlist name.
		
		List<String> accountlist = new ArrayList<>();
		List<WebElement> elelist= dr.findElements(accountsection);
		
		for(WebElement e : elelist){
			String accountname = e.getText();
			System.out.println("Accounts list name:= " + accountname);
			accountlist.add(accountname);
		}
		
		return accountlist;
	}
}
