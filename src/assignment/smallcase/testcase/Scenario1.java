package assignment.smallcase.testcase;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import assignment.smallcase.HomePage;
import assignment.smallcase.ProductCartPage;
import assignment.smallcase.ProductPage;
import assignment.smallcase.ResultPage;
import utility.BrowserFactory;

public class Scenario1 {

	@Test
	public void itemOnFlipkart() throws InterruptedException
	{
		//browser and page launch
		WebDriver driver = BrowserFactory.startBrowser("chrome","https://www.flipkart.com/ ");
		//Page Object creation using Page Factory for home page
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		HomePage homePage=PageFactory.initElements(driver, HomePage.class);
		//call to cancel login popup method
		homePage.cancelLoginPopUp();
		//call to Home page method
		homePage.searchItem("OnePlus Bullets wireless z");
		Thread.sleep(2000);
		//Page Object creation using Page Factory for result page
		ResultPage resultPage=PageFactory.initElements(driver, ResultPage.class);
		//call to result page method
		resultPage.FirstItem();
		//call to go to product page method
		resultPage.goToProductPage();
		Thread.sleep(2000);
		//Page Object creation using Page Factory for product page
		ProductPage productPage=PageFactory.initElements(driver, ProductPage.class);
		//print product price , call to product page method
		int productPrice = productPage.getPrice();
		System.out.println("Price of the Product : Rs" +productPrice);
		//clicking on Add to Cart button , call to product page method
		productPage.AddProductToCart();
		Thread.sleep(2000);
		//Page Object creation using Page Factory for ProductCart page
		ProductCartPage cart = PageFactory.initElements(driver, ProductCartPage.class);
		//Increase Quantity of Product , call to ProductCart page method
		cart.increaseProductQuantity();
		//print total price after addition
		int amount = cart.getTotalAmount();
		System.out.println("Amount after increasing quantity of the product : Rs"+amount);
		//call to quit browser method
		BrowserFactory.closeBrowser();
		
	}
	
	
}
