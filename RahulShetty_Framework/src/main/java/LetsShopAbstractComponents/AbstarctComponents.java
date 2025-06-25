package LetsShopAbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LetsShopPageObject.CheckoutPage;

public class AbstarctComponents {
	
	WebDriver driver;
	
	public AbstarctComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement CartButton; 
	
	public void ElementToVisible(WebElement element)
	{
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public CheckoutPage GotoCart() throws InterruptedException
	{
		Thread.sleep(2000);
		CartButton.click();
		CheckoutPage c=new CheckoutPage(driver);
		return c;
	}
	
	public void scrollToElement(WebElement element)
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", element);
	}


    

}
