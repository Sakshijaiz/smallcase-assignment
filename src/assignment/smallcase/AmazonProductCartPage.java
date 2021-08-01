package assignment.smallcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductCartPage {
	
WebDriver driver;
	
	public AmazonProductCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"hlb-subcart\"]/div[1]/span/span[2]")
	WebElement ProductPrice;
			
	public int getTotalAmount()
	{	
		String Amount =ProductPrice.getText();
		String TAmount=Amount.substring(1,2).concat(Amount.substring(3,6));
		int totalAmount=Integer.parseInt(TAmount);
		return totalAmount;
	}
}
