package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.seleniumTask.tests.DataLoader;

public class DraftsPage {
	private WebDriver driver;
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
	public 	Boolean checkDrafts(DataLoader testData){
		boolean recCheck=false;
		boolean subjCheck=false;
		for (WebElement webElement : recip) {
			if(webElement.getText().contains(testData.getRecipient()))recCheck=true;
		}
		for (WebElement webElement : subj) {
			if(webElement.getText().contains(testData.getSubject()))subjCheck=true;
		}
		return recCheck & subjCheck;
	}
	public NewMailPage writeMail(){
		new Actions(driver).click(newMailButton).build().perform();
		return new NewMailPage(driver);
	}
}
