package LetsShopPageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LetsShopAbstractComponents.AbstarctComponents;


	public class CheckoutPage extends AbstarctComponents{
		
		WebDriver driver;
		
		public CheckoutPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;	
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//button[text()='Checkout']")
		WebElement CheckoutButton; 
		
		@FindBy(xpath="//input[@fdprocessedid=\"bzhuv\"]")
		WebElement CVV; 
		
		@FindBy(xpath="//input[@fdprocessedid=\"m0zlve\"]")
		WebElement NameOfCard; 
		
		@FindBy(xpath="//input[@placeholder=\"Select Country\"]")
		WebElement Country; 
		
		@FindBy(xpath="(//button[contains(@class, 'ng-star-inserted')])[2]")
		WebElement SelectCountry;
		
		@FindBy(xpath="//a[text()='Place Order ']")
		WebElement PlaceOrderButton;
		
		
		//(//button[contains(@class, 'ng-star-inserted')])[2]
		//input[@placeholder="Select Country"]
		
		
		public void ClickCheckOut() throws InterruptedException
		{
			ElementToVisible(CheckoutButton);
			CheckoutButton.click();
		}
		
		public void AddCardDetials(String cvv, String CardName)
		{
			ElementToVisible(CVV);
			CVV.click();
			CVV.sendKeys(cvv);
			NameOfCard.click();
			NameOfCard.sendKeys(CardName);
			
		}
		
		public void SelectCountry(String CountryName)
		{

			Actions a= new Actions(driver);
			a.sendKeys(Country,CountryName).build().perform();
			ElementToVisible(SelectCountry);
			SelectCountry.click();
			
			
		}

		public ConfirmationPage PlaceOrder()
		{
			scrollToElement(PlaceOrderButton);
			ElementToVisible(PlaceOrderButton);
			PlaceOrderButton.click();	
			ConfirmationPage cn= new ConfirmationPage(driver);
			return cn;
		}
}
