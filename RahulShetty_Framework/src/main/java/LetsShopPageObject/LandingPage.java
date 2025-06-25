package LetsShopPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LetsShopAbstractComponents.AbstarctComponents;

public class LandingPage extends AbstarctComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement clickButton;
	
	public ProductCatlogue LoginApplication(String uname,String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		clickButton.click();
		ProductCatlogue p= new ProductCatlogue(driver);
		return p;
	}
	
	public void gotoApplication(String url)
	{
		driver.get(url);
	}
	
}
