package pageloader;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException; 
import java.awt.Robot;
import java.awt.event.KeyEvent;

import base.CaseTestBase;

public class Purchase extends CaseTestBase{
	WebDriverWait wait;
	@FindBy(xpath="//button[text()='Place Order']")
	WebElement placeorder;
	
//	@FindBy(id="cartur")
//	WebElement cart;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="card")
	WebElement card;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//button[text()='Purchase']")
	public WebElement purchase;
	
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	public WebElement message;
	public Purchase() {
		PageFactory.initElements(driver, this);
	}
	
	public void order() throws InterruptedException{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		placeorder.click();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		name.sendKeys(prop.getProperty("username"));
//		wait.until(ExpectedConditions.visibilityOf(country));
		country.sendKeys(prop.getProperty("country"));
//		wait.until(ExpectedConditions.visibilityOf(city));
		city.sendKeys(prop.getProperty("city"));
//		wait.until(ExpectedConditions.visibilityOf(card));
		card.sendKeys(prop.getProperty("credit"));
//		wait.until(ExpectedConditions.visibilityOf(month));
		month.sendKeys(prop.getProperty("month"));
//		wait.until(ExpectedConditions.visibilityOf(year));
		year.sendKeys(prop.getProperty("year"));
//		wait.until(ExpectedConditions.visibilityOf(purchase));
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  for (int i = 0; i < 2; i++) {
			  robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_SUBTRACT);
			  robot.keyRelease(KeyEvent.VK_SUBTRACT);
			  robot.keyRelease(KeyEvent.VK_CONTROL);
			  }
		Thread.sleep(5000);
		purchase.click();
		Thread.sleep(3000);
		okbtn.click();
		
		
	}
}
