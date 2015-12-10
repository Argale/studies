package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	@FindBy(id = "mailbox__login")
	private WebElement loginField;
	@FindBy(id = "mailbox__password")
	private WebElement passField;
	@FindBy(id = "mailbox__auth__button")
	private WebElement loginButton;

	public boolean loginCheck(){
		try{
			WebElement temp=driver.findElement(By.id("PH_user-email"));
			return temp.isDisplayed();
		}catch(Exception e){
			return false;
		}
	};
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public LoginPage sendLogin(String login) {
		new Actions(driver).click(loginField).sendKeys(login).build().perform();
		return this;
	}

	public LoginPage sendPass(String pass) {
		new Actions(driver).click(passField).sendKeys(pass).build().perform();
		return this;
	}

	public MainPage submit() {
		new Actions(driver).click(loginButton).perform();
		return new MainPage(driver);
	}
}
