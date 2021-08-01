package assignment.smallcase.testcase;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import assignment.smallcase.AmazonHomePage;
import assignment.smallcase.AmazonProductCartPage;
import assignment.smallcase.AmazonProductPage;
import assignment.smallcase.AmazonResultPage;
import assignment.smallcase.HomePage;
import assignment.smallcase.ProductCartPage;
import assignment.smallcase.ProductPage;
import assignment.smallcase.ResultPage;
import utility.BrowserFactory;

public class Scenario2 {

	@Test
	public void itemOnFlipkart() throws InterruptedException
	{
		//browser and page launch
		WebDriver driver = BrowserFactory.startBrowser("chrome","https://www.flipkart.com/ ");
		//Page Object creation using Page Factory for home page
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
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
		System.out.println("Price of the Product on Flipkart :Rs" +productPrice);
		//clicking on Add to Cart button , call to product page method
		productPage.AddProductToCart();
		Thread.sleep(2000);
		//Page Object creation using Page Factory for ProductCart page
		ProductCartPage cart = PageFactory.initElements(driver, ProductCartPage.class);
		//print price in cart , call to get Total Amount
		int FlipkartAmount = cart.getTotalAmount();
		System.out.println("Total Amount of product on Flipkart :Rs"+FlipkartAmount);
		//call to Open Amazon method
		cart.openAmazon("https://www.amazon.in/");
		Thread.sleep(2000);
		//Page Object creation using page factory for Amazon HomePage
		AmazonHomePage amazonHome =PageFactory.initElements(driver, AmazonHomePage.class);
		//call to homePage method
		amazonHome.searchItem("OnePlus Bullets wireless z");
		Thread.sleep(2000);
		//Page Object creation using Page Factory for result page
		AmazonResultPage amazonResultPage=PageFactory.initElements(driver, AmazonResultPage.class);
		//call to result page method
		amazonResultPage.openResultItem();
		//call to product page
		amazonResultPage.goToProductPage();
		Thread.sleep(2000);
		//Page object creation for product page
		AmazonProductPage amazonProductPage = PageFactory.initElements(driver, AmazonProductPage.class);
		//call to get price method
		int amazonProductPrice = amazonProductPage.getPrice();
		System.out.println("Price of the Product on Amazon :Rs" +amazonProductPrice);
		//clicking on Add to Cart button , call to product page method
		amazonProductPage.AddProductToCart();
		Thread.sleep(2000);
		//Page object creation using page factory for Cart Price method
		AmazonProductCartPage amazonProductCart = PageFactory.initElements(driver, AmazonProductCartPage.class);
		//call to getTotal Amount method
		int AmazonPrice=amazonProductCart.getTotalAmount();
		System.out.println("Total Amount of product on Amazon :Rs"+AmazonPrice);
		Thread.sleep(2000);
		//call to getPriceComparison method , print comparison result
		//String result=amazonProductCart.getPriceComparison();
		//System.out.println(result);
		try {
			
			if(FlipkartAmount==AmazonPrice)
			{ 
				System.out.println("Product price at both Amazon and Flipkart sites are same !!");
			}
			else if(FlipkartAmount<AmazonPrice)
			{
				System.out.println("Product price at Flipkart site is cheaper !");
			}
			else
			{
				System.out.println("Product price at Amazon site is cheaper !");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//call to quit browser method
		BrowserFactory.closeBrowser();
				
	}

}
