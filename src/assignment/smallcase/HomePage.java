package assignment.smallcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div/div/button")
	WebElement LoginPopUp;
	
	@FindBy(how=How.NAME,using="q") 
	WebElement search;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button")
	WebElement search_button;
	
	public void cancelLoginPopUp()
	{
		LoginPopUp.click();
	}
	
	public void searchItem(String item)
	{
		search.sendKeys(item);
		search_button.click();
	}

}
