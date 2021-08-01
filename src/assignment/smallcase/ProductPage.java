package assignment.smallcase;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage {

WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div[1]") 
	WebElement price;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
	WebElement Add_To_Cart_Button;
	
	public int getPrice()
	{
		String ProductPrice = price.getText();
		String Amount=ProductPrice.substring(1,2).concat(ProductPrice.substring(3));
		int ProductAmount=Integer.parseInt(Amount);
		
		return ProductAmount;
	}
	
	public void AddProductToCart()
	{
		Add_To_Cart_Button.click();
	}

	
}
