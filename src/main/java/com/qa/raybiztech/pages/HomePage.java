package com.qa.raybiztech.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.raybiztech.utils.Constants;
import com.qa.raybiztech.utils.ElementUtil;

public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1.Private By locator
	private By rbtlogo = By.xpath("//img[position()=1]");
	private By rbt13yearscelebrationlogo = By.xpath("//img[@alt='Ray Business Technologies 13 years celebration']");
	private By wearehiringlogo = By.xpath("//img[@class='we-are-hiring-img sm-img hidden-xs']");
	private By searchbutton = By.xpath("//input[@id='search_global']");
	private By mainmenuicon = By.xpath("//button[@id='js_main-menu-icon']");
	private By kenticoxperience13linkheader = By.xpath("//h1[@class='banner_heading2 hidden-xs wow fadeInLeft animated']");
	private By artificialintelligencelink = By.xpath("//a[text()='ARTIFICIAL INTELLIGENCE']/.");
	private By dynamics365link = By.xpath("//a[text()='Dynamics 365']");
	private By kenticoxperience13link = By.xpath("//a[text()='KENTICO XPERIENCE 13']");
	private By careerslink = By.xpath("//a[text()='CAREERS ']");
	private By contactlink = By.xpath("//a[normalize-space()='CONTACT']");
	
	//2. page constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3.public page actions or methods
	public String getHomePageTitle() {
		return eleUtil.doGetPageTitleIs(Constants.Home_Page_Title, Constants.Default_Time_Out);
	}
	
	public String getHomePageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isRbtLogoExist() throws InterruptedException {
		return eleUtil.doIsDisplayed(rbtlogo);
		
	}
	
	public ArtificialIntelligencePage goToArtificialIntelligencePage() {
		eleUtil.doClick(artificialintelligencelink);
		return new ArtificialIntelligencePage(driver);
	}
	
	public ContactPage goToContactPage() {
		eleUtil.doClick(contactlink);
		return new ContactPage(driver);
	}
	
	
	
	
}
