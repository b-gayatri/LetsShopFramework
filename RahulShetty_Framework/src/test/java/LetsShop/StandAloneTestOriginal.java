package LetsShop;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import LetsShopPageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
public class StandAloneTestOriginal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// This is standalone framework without POM
		
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		//
		LandingPage l=new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("gaurav@gamil.com");
		driver.findElement(By.id("userPassword")).sendKeys("Gaurav@1234");
		driver.findElement(By.xpath("//input[@id=\"login\"]")).click();
		Thread.sleep(3000);
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3"))));
		
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		for(WebElement p: products)
		{
			String productName=p.findElement(By.cssSelector(".mb-3 b")).getText();
			if(productName.equals("ZARA COAT 3"))
			{
				p.findElement(By.cssSelector("div div button:last-of-type")).click();
				Thread.sleep(2000);
			}
			
		//	System.out.println(p.findElement(By.cssSelector(".mb-3 b")).getText());
			
		}
		
		WebDriverWait wait1 =new WebDriverWait(driver, Duration.ofSeconds(2));
		wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id=\"toast-container\"]"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		System.out.println("--------------------");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@fdprocessedid=\"bzhuv\"]")).sendKeys("123"); //cvv
//		driver.findElement(By.xpath("//input[@fdprocessedid=\"m0zlve\"]")).sendKeys("mastercard"); //name of card
		
		Actions a= new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")),"India").build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(@class, 'ng-star-inserted')])[2]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).sendKeys("India");
		//driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")).submit();
		
		a.moveToElement(driver.findElement(By.xpath("//a[text()='Place Order ']"))).build().perform();
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		Thread.sleep(2000);
		String msg=driver.findElement(By.xpath("//h1[@class=\"hero-primary\"]")).getText();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		Thread.sleep(2000);
		driver.close();
	}

}
