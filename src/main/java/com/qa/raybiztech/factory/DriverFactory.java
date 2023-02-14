package com.qa.raybiztech.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	
	
	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal();
	
	
	
	/**
	 * this method is used to initialize the browser using browser name
	 * @param browsername
	 * @return this return the WebDriver
	 * @author Amarendra Pani
	 */
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		highlight = prop.getProperty("highlight").trim();
		System.out.println("browser name is :"+ browserName);
		optionsManager = new OptionsManager(prop);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			tlDriver.set(new InternetExplorerDriver());
		}
		else if (browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			//driver = new OperaDriver();
			tlDriver.set(new OperaDriver());
		}
		else {
			System.out.println("Please pass the valid browser name : " + browserName);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url").trim());
		return getDriver();
		
		}
	
	/**
	 * this will return the thread local copy of the driver
	 * @return
	 * @author Amarendra Pani
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * This method is used to initialize the properties
	 * @return
	 * @author Amarendra Pani
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}
	
	/**
	 * This method is used to take the screenshot for pass,fail and skip test_cases
	 * @return this return the path
	 * @author Amarendra pani
	 */
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis()+".png" ;
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch(IOException e){
			e.printStackTrace();
		}
		
		return path;
	}




}