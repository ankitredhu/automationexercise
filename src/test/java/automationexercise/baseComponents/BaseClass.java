package automationexercise.baseComponents;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import automationexercise.pageObjects.LaunchWebsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class BaseClass {
	
	WebDriver driver;
	LaunchWebsite launchWebsite;
	
	// initialize driver
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\automationexercise\\resources\\globalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") !=null? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.contains("edge")) {
			System.setProperty("webDriver.edge.driver", "C:\\Selenium\\edge\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		}else if(browserName.contains("chrome")){
			System.setProperty("webDriver.chrome.driver", "C:\\Selenium\\ankit\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public LaunchWebsite startApplication() throws IOException {
		
		driver = initializeDriver();
		launchWebsite = new LaunchWebsite(driver);
		launchWebsite.hitURL();
		return launchWebsite;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	public   List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		String JsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//String to HashMap - Jackson databind
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> map = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>(){
		});
		
		return map;
	}
	
	

}
