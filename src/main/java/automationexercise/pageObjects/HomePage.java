package automationexercise.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationexercise.abstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='single-products']")
	List<WebElement> productsList; 
	
	@FindBy(xpath= "//a[contains(@href, 'product_details')]")
	WebElement productElement;
	
	public void sampleMethod(String productToFind) {
		for(WebElement product : productsList ) {
			if(productToFind.equals(product.findElement(By.xpath("//p[@text()='productToFind']")).getText()));
			System.out.println("Element found");
		}
	}

}
