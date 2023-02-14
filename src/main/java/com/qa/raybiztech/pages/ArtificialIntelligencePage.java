package com.qa.raybiztech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.raybiztech.utils.Constants;
import com.qa.raybiztech.utils.ElementUtil;

public class ArtificialIntelligencePage {
private WebDriver driver;
private ElementUtil eleUtil;
	
	//1.Private By locator
	private By technologypeopleprocessheader = By.xpath("//div[contains(.,'Technology + People + Process')]");
	private By enterpriseresourceplanninglink = By.xpath("//a[text()='Enterprise Resource Planning']");
	private By enterpriseportalcontentmanagementlink = By.xpath("//a[text()='Enterprise Portal & Content Management']");
	private By ecommercesociallink = By.xpath("//a[text()='E-Commerce & Social']");
	private By customerrelationshipmanagementlink = By.xpath("//a[text()='Customer Relationship Management']");
	
	
	//2. page constructor
	public ArtificialIntelligencePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
	//3.public page actions or methods
	public String getArtificialIntelligencePageTitle() {
		return eleUtil.doGetPageTitleIs(Constants.ArtificialIntelligence_Page_Title, Constants.Default_Time_Out);
	}
	public boolean isAipheaderExist(){
		return eleUtil.doIsDisplayed(technologypeopleprocessheader);
		
	}
	
	
	
	

}
