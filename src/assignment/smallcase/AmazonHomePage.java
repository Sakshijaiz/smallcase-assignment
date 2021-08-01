package assignment.smallcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AmazonHomePage {
		
		WebDriver driver;
		
		public AmazonHomePage(WebDriver driver)
		{
			this.driver=driver;
		}
			
		@FindBy(how=How.ID,using="twotabsearchtextbox") 
		WebElement search;
		
		@FindBy(how=How.ID,using="nav-search-submit-button")
		WebElement search_button;
			
		public void searchItem(String item)
		{
			search.sendKeys(item);
			search_button.click();
		}


}
