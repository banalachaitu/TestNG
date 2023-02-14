package com.qa.raybiztech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.raybiztech.utils.ElementUtil;

public class Dynamic365Page {
	
private WebDriver driver;
private ElementUtil eleUtil;
	
	//1.Private By locator
	private By providingheader = By.xpath("//h2[contains(text(),'Providing Microsoft Dynamics 365 Development, Implementation & Technology Consulting to Leading Enterprises')]");
	private By dynamix365 = By.xpath("//a[text()='Dynamics 365']");
	private By microsoftdynamicsAX = By.xpath("//a[text()='Microsoft Dynamics AX']");
	private By microsoftdynamicsnav = By.xpath("//a[text()='Microsoft Dynamics NAV']");
	
	
	//2. page constructor
	public Dynamic365Page(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	

}
