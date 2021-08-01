package assignment.smallcase;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCartPage {

WebDriver driver;
	
	public ProductCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/button[2]")
	WebElement IncreaseQuantity;
	
	@FindBy(how=How.XPATH,using="//input[contains(@class,'_253qQJ')]")
	WebElement Quantity;
		
	public void increaseProductQuantity()
	{
		IncreaseQuantity.click();
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[4]/div/span/div/div/span")
	WebElement TotalAmount;
	
	public int getTotalAmount()
	{	
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(IncreaseQuantity));
		String Amount =TotalAmount.getText();
		String TAmount=Amount.substring(1,2).concat(Amount.substring(3));
		int totalAmount=Integer.parseInt(TAmount);
		return totalAmount;
	}
	
	public void openAmazon(String url) throws InterruptedException
	{
				Thread.sleep(3000);
				driver.navigate().to(url);
		
	}
	
}
