package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import businessObject.Account;
public class LoginPage extends BasicMail{
	private Account account;
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
	public void setAccount(Account account){
		this.account=account;
	}
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public LoginPage selectDomain(){
		int cashedIndex=0;
		List< WebElement> options=driver.findElements(By.tagName("option"));
		for (int i=0;i<options.size();i++) {
			if(options.get(i).getText().contains(account.getDomain()))
				cashedIndex=i;
		}
		new Actions(driver).click(options.get(cashedIndex)).build().perform();
		return this;
	}
	public LoginPage sendLogin() {
		new Actions(driver).click(loginField).sendKeys(account.getLogin()).build().perform();
		return this;
	}

	public LoginPage sendPass() {
		new Actions(driver).click(passField).sendKeys(account.getPassword()).build().perform();
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
