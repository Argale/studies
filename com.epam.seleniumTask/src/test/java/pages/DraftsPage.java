package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftsPage extends BasicMail{
	@FindBy(className="b-datalist__item__addr")
	private List<WebElement> recip;
	@FindBy(className="b-datalist__item__subj")
	private List<WebElement> subj;
	@FindBy(className="b-toolbar__btn")
	private WebElement newMailButton;
	
	public DraftsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	public 	Boolean checkDrafts(){
		boolean recCheck=false;
		boolean subjCheck=false;
		long timeout=3;
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		for (WebElement webElement : recip) {
			if(webElement.getText().contains(inputContent.getRecipient()))recCheck=true;
		}
		for (WebElement webElement : subj) {
			if(webElement.getText().contains(inputContent.getSubject()))subjCheck=true;
		}
		return recCheck & subjCheck;
	}
	public NewMailPage writeMail(){
		new Actions(driver).click(newMailButton).build().perform();
		return new NewMailPage(driver);
	}
}
