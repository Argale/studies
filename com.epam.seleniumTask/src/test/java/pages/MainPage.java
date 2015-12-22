package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
public class MainPage {
	private WebDriver driver;
	@FindBy(xpath="//*[@id=\"b-nav_folders\"]/div/div[3]/a")
	WebElement draftsButton;
	@FindBy(className="b-toolbar__btn")
	private WebElement newMailButton;
	WebElement targetMail;
	public MainPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	public DraftsPage goToDrafts(){
		new Actions(driver).click(draftsButton).build().perform();
		return new DraftsPage(driver);
	}
	public NewMailPage goToSender(){
		new Actions(driver).click(newMailButton).build().perform();
		return new NewMailPage(driver);
	}
	public LoginPage clickExitButton() {
		  WebElement outButton = (WebElement) ((JavascriptExecutor) driver)
		    .executeScript("document.getElementById('PH_logoutLink').click()");
		  ((JavascriptExecutor) driver).executeScript("arguments[0]", outButton);
		  return new LoginPage(driver);
		 }
	public void acceptAlert(){
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
}
