package assignment.smallcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AmazonProductPage {

	WebDriver driver;
	
	public AmazonProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.ID,using="priceblock_ourprice")
	WebElement price;
	
	@FindBy(how=How.ID,using="add-to-cart-button")
	WebElement Add_To_Cart_Button;
	
	public int getPrice()
	{
		String ProductPrice = price.getText();
		String Amount=ProductPrice.substring(1,2).concat(ProductPrice.substring(3,6));
		int ProductAmount=Integer.parseInt(Amount);
		
		return ProductAmount;
	}
	
	public void AddProductToCart()
	{
		Add_To_Cart_Button.click();
	}

}
