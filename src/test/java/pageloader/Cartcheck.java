package pageloader;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.CaseTestBase;

public class Cartcheck extends CaseTestBase {
    public String price;
    public int cart_size;
	@FindBy(id="cartur")
	WebElement cart;
	
	@FindBy(id="totalp")
	WebElement pricenum;
	
	@FindBy(xpath="//tbody//td[2]")
	public List<WebElement> items_in_cart;
	
	public Cartcheck() {
		PageFactory.initElements(driver, this); 
	}
	
	public void cart() {
		cart.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		price = pricenum.getText();
		cart_size = items_in_cart.size();
	}
}
