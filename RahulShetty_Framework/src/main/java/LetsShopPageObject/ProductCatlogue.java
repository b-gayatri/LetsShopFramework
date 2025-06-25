package LetsShopPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LetsShopAbstractComponents.AbstarctComponents;

public class ProductCatlogue extends AbstarctComponents{
	
	WebDriver driver;
	
	public ProductCatlogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products; 
	
	@FindBy(css=".mb-3")
	WebElement product; 
	
	
	
	public List<WebElement> getProductList()
	{
		ElementToVisible(product);
		return products;
	}
	
	public WebElement getProductByName(String PName)
	{
		for(WebElement p1: products)
		{
			String productName=p1.findElement(By.cssSelector(".mb-3 b")).getText();
			if(productName.equals(PName))
			{
				//AddToCart.click();
				
				return p1;
			}
			//break;
		}
		
		return null;
	}
	
	public void AddProductTocart(WebElement e)
	{
		WebElement p1=getProductByName("ADIDAS ORIGINAL");
		WebElement AddToCart=p1.findElement(By.cssSelector("div div button:last-of-type"));
		ElementToVisible(AddToCart);
		AddToCart.click();
		
	}
}
	
