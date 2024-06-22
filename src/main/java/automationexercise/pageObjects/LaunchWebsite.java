package automationexercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.abstractComponents.AbstractComponents;

public class LaunchWebsite extends AbstractComponents {
	
	WebDriver driver;
	public LaunchWebsite(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="a[href='/login']")
	WebElement logInButton;
	
	public void hitURL() {
		driver.get("https://automationexercise.com/");
		
	}
	
	public LoginPage goToLogIn() {
		logInButton.click();
		return new LoginPage(driver);
	}

}
