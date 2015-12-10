package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	private static final String MAIL_CLASS = "b-datalist__item__subj__snippet";
	private static final String DELETED = "Корзина";
	private static final String TARGET_TEXT ="test text";
	private WebDriver driver;
	@FindBy(xpath="//*[@id=\"b-nav_folders\"]/div/div[3]/a/span")
	WebElement draftsButton;
	WebElement targetMail;
	WebElement deleteFolder;
	
	private void findDeleteFolder(){
		List<WebElement> spans=driver.findElements(By.tagName("span"));
		for(int i=0;i<spans.size();i++){
			if(spans.get(i).getText().contains(DELETED))
				deleteFolder=spans.get(i);
		}
	}
	private void findTestMail(){
		List<WebElement> mailList=driver.findElements(By.className(MAIL_CLASS));
		for(int i=0;i<mailList.size();i++){
			if(mailList.get(i).getText().contains(TARGET_TEXT))
				targetMail=mailList.get(i);
		}
	}
	public MainPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	public MainPage deleteMessage(){
		findDeleteFolder();
		findTestMail();
		new Actions(driver).clickAndHold(targetMail).moveToElement(deleteFolder).build().perform();
		new Actions(driver).release().build().perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		new Actions(driver).click(deleteFolder);
		return this;
	}
	public DraftsPage goToDrafts(){
		new Actions(driver).click(draftsButton).build().perform();
		return new DraftsPage(driver);
	}
}
