package LetsShopPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LetsShopAbstractComponents.AbstarctComponents;

public class ConfirmationPage extends AbstarctComponents{
		
		WebDriver driver;
		
		public ConfirmationPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;	
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//h1[@class='hero-primary']")
		WebElement ConfirmationMessage;
		
		public String GetConfirmationMessage()
		{
			ElementToVisible(ConfirmationMessage);
			return ConfirmationMessage.getText();
			//Assert.assertTrue(messge.equalsIgnoreCase("Thankyou for the order."));
		}
		
		
}
