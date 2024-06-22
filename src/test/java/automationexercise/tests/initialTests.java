package automationexercise.tests;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationexercise.baseComponents.BaseClass;
import automationexercise.pageObjects.HomePage;
import automationexercise.pageObjects.LaunchWebsite;
import automationexercise.pageObjects.LoginPage;


public class initialTests extends BaseClass {
	 
	@Test(dataProvider="getData")
	public void firstTest(HashMap<String,String> input) throws IOException {
		LaunchWebsite launchWebsite = startApplication();
	    LoginPage loginPage = launchWebsite.goToLogIn();
	    HomePage homePage = loginPage.logIn(input.get("email"), input.get("password"));
	    homePage.sampleMethod("Blue Top");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\automationexercise\\data\\logInCred.json");
		
		return new Object[][] {{data.get(0)}};
		
	}
}
