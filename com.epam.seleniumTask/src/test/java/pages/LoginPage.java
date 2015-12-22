package pages;

import java.util.List;

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
	@FindBy(id="mailbox__login__domain")
	private WebElement domainSelector;
	@FindBy(css="#mailbox__login__domain > option:nth-child(1)")
	private WebElement requiredOption;
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
	public LoginPage selectDomain(String domain){
		int cashedIndex=0;
		List< WebElement> options=driver.findElements(By.tagName("option"));
		for (int i=0;i<options.size();i++) {
			if(options.get(i).getText().contains(domain))
				cashedIndex=i;
		}
		new Actions(driver).click(options.get(cashedIndex)).build().perform();
		return this;
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
	public boolean exitCheck() {
		if (driver.findElement(By.id("mailbox__login")).isDisplayed()
				&& driver.findElement(By.id("mailbox__password")).isDisplayed())
			return true;
		else
			return false;
	}
}
