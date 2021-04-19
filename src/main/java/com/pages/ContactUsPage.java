package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class ContactUsPage {
	
	private WebDriver dr;

	//1.Locators:
	private By subjectHeading = By.id("id_contact");
	private By email = By.id("email");
	private By orderRef = By.id("id_order");
	private By messageText = By.id("message");
	private By sendButton = By.id("submitMessage"); 
	private By successMessg = By.cssSelector("div#center_column p");

	//2.Constructor Of the page
		public ContactUsPage(WebDriver wdr){     //for Constructor need webdriver and give webdriver to private webdriver(value come from different pagewebdrivefr to this page's webdriver).
		    this.dr = wdr;
			
		}
		
		public String getContactUsPageTitle() {
			return dr.getTitle();
		}
		
		public void fillCotactUsForm(String Heading, String Email, String OrderRef, String Msg){
			Select select = new Select(dr.findElement(subjectHeading));
			select.selectByVisibleText(Heading);
			dr.findElement(email).sendKeys(Email);
			dr.findElement(orderRef).sendKeys(OrderRef);
			dr.findElement(messageText).sendKeys(Msg);
		}
		
		public void clickSend() {
			dr.findElement(sendButton).click();
		}
		
		public String getSuccessMessg() {
			return dr.findElement(successMessg).getText();
		}
}
