package assignment.smallcase;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResultPage {

WebDriver driver;
	
	public ResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/a[2]") 
	WebElement First_Result_Item;
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div[1]")
	WebElement Price;
	
	
	public void FirstItem()
	{
	
		First_Result_Item.click();
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
