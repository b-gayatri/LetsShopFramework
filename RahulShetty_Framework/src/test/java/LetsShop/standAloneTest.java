package LetsShop;

import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.http.message.BasicNameValuePair;
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

import LetsShop.TestComponent.BaseTest;
import LetsShopPageObject.CheckoutPage;
import LetsShopPageObject.ConfirmationPage;
import LetsShopPageObject.LandingPage;
import LetsShopPageObject.ProductCatlogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standAloneTest extends BaseTest {

	public static void main(String[] args) throws Exception {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		LandingPage l = new LandingPage(driver);
		l.gotoApplication("https://rahulshettyacademy.com/client");
		ProductCatlogue p = l.LoginApplication("gaurav@gamil.com", "Gaurav@1234");

		// ProductCatlogue p= new ProductCatlogue(driver);
		List<WebElement> products = p.getProductList();
		WebElement product = p.getProductByName("ADIDAS ORIGINAL");
		p.AddProductTocart(product);
		CheckoutPage c = p.GotoCart();

		// CheckoutPage c=new CheckoutPage(driver);
		c.ClickCheckOut();
		// c.AddCardDetials("123", "MasterCard");
		c.SelectCountry("India");
		ConfirmationPage cn = c.PlaceOrder();
		String ActualMessage = cn.GetConfirmationMessage();
		Assert.assertTrue(ActualMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();

	}

}
