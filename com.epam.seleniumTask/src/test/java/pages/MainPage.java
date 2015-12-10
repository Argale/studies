package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	private WebDriver driver;
	@FindBy(xpath="//*[@id=\"b-nav_folders\"]/div/div[3]/a/span")
	WebElement dragtsButton;
	public MainPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	public DraftsPage goToDrafts(){
		new Actions(driver).click(dragtsButton).build().perform();
		return new DraftsPage(driver);
	}
}
