package automationexercise.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.abstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//log in email
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement logInEmail;
	
	//log in password
	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement logInPassword;
	
	//log in button
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement logInButton;
	
	public HomePage logIn(String userEmail, String userPassword) {
		logInEmail.sendKeys(userEmail);
		waitForCompleteText(logInEmail,userEmail);
		logInPassword.sendKeys(userPassword);
		waitForCompleteText(logInPassword,userPassword);
		logInButton.click();
		return new HomePage(driver);
	}
	

}
