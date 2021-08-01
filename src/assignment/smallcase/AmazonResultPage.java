package assignment.smallcase;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AmazonResultPage {
	
WebDriver driver;
	
	public AmazonResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div[2]/div[1]/div/div[1]/div/span[3]/div[2]/div[4]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img") 
	WebElement Result_Item;
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div[1]")
	WebElement Price;
	
	
	public void openResultItem()
	{
	
		Result_Item.click();
	}
	
	public void goToProductPage()
	{
		Set<String> windowHandle = driver.getWindowHandles();
		for(String handle : windowHandle)
		{
			driver.switchTo().window(handle);
		}
	}


}
