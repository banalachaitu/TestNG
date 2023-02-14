package com.qa.raybiztech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.raybiztech.utils.ElementUtil;

public class ContactPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
		
		//1.Private By locator
		private By name = By.xpath("//input[@data-val-required='Please enter valid Name']");
		private By email = By.xpath("(//input[@data-val-required='Please enter valid Email'])[1]");
		private By phonnumber = By.xpath("(//input[@id='Phone'])[1]");
		private By country = By.xpath("//select[@id='Country']");
		private By message = By.xpath("(//input[@id='Message'])[1]");
		private By resetbutton = By.xpath("//input[@type='reset']");
		private By submitbutton = By.xpath("//input[@type='submit']");
		
		
		//2. page constructor
		public ContactPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
			
		}
		//3.public page actions or methods
		public boolean getInTouchRegisterResetFunction(String name,String email,String phonnumber,String country,String message,String button){
			
			eleUtil.doSendKeys(this.name, name);
			eleUtil.doSendKeys(this.email, email);
			eleUtil.doSendKeys(this.phonnumber, phonnumber);
			eleUtil.selectValueFromDropDown(this.country, country);
			eleUtil.doSendKeys(this.message, message);
		
			if (button.equalsIgnoreCase("submit")){
				eleUtil.doClick(submitbutton);
			}else {
				eleUtil.doClick(resetbutton);
			}
			
			if(eleUtil.doGetText(this.message)== "") {
				return true;
			}
			return false;	
		}

}
