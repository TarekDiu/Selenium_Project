package step_definations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utlis.ExcelReader;




public class Hooks extends Base {
	@Before
	public void setup() throws IOException, InvalidFormatException{
		
		
		// initialize Propertie  file

		config = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
		config.load(fis);

		// initialize excel file

		excelReader = new ExcelReader();
		testData = excelReader.getData(System.getProperty("user.dir") 
				+ "\\src\\test\\resources\\testData\\loginTest.xlsx", "LoginTestData");
		
		// initialize all Browser just change env file in the config file 

		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);

		switch (config.getProperty("browser")) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(false); // optional
			driver = new FirefoxDriver(firefoxOptions);
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeoptions = new EdgeOptions();
			driver = new EdgeDriver(edgeoptions);
			break;

		}

		host = config.getProperty("env");//This is the website link which come from config file 
		
		
		// added the time 

		int seconds = Integer.parseInt(config.getProperty("implisitWait"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		System.out.println("before run");
	}

	@After
	public void teardown() throws IOException {

		System.out.println("After Run Succcessfully");
		 fis.close(); 
		 driver.quit();

	}

	
	/*  public void tearDown(Scenario scenario) throws IOException {
	  System.out.println("after run");
	  
	  try { String screenshotName = scenario.getName().replace("", ""); if
	  (scenario.isFailed()) { scenario.log("this is my failure message");
	  TakesScreenshot ts = (TakesScreenshot) driver; byte[] screenshot =
	  ts.getScreenshotAs(OutputType.BYTES); scenario.attach(screenshot,
	  "image/png", screenshotName); } } catch (Exception e) { e.printStackTrace();
	  }*/
	  
	  
	
	  
	  }
	 


