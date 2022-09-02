package com.qa.linkedin.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	private File f=null;
	private static Logger log=Logger.getLogger(TestBase.class);
	
	/**
	 * this method reads the property value from properties file
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	
	
	public String readPopertyValue(String key) throws IOException {
		log.info("create object for properties class");
		Properties prop=new Properties();
		log.info("read the properties file");
		try {
		FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\linkedin\\config\\confi.properties"));
		log.info("outside file location");
		prop.load(fis);
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return prop.getProperty(key);	
	}
	
	@BeforeSuite
	public void setup() throws IOException {
		log.info("reading the browser value from propprties file");
		String browserName=readPopertyValue("browser");
		log.info("launching the browser"+browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
			  WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
		  } else if(browserName.equalsIgnoreCase("firefox")) {
			  WebDriverManager.firefoxdriver().setup();
			  driver=new FirefoxDriver();
		  } else if(browserName.equalsIgnoreCase("edge")) {
			  WebDriverManager.edgedriver().setup();
			  driver=new EdgeDriver();
		  } 
			 driver.manage().window().maximize();
			  
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 Reporter.log("create boject for webdriverwait class");
			 wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
			 log.debug("open the application url:"+readPopertyValue("AppUrl"));
			driver.get(readPopertyValue("AppUrl"));
		
		
		
	}
	@AfterSuite
	public void tearDown() {
		log.debug("close the browser");
		if(driver!=null)
			driver.quit();
		
	}
	
	
	
	
	
	

}
