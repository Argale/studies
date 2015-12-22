package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.epam.seleniumTask.tests.DataLoader;

public class NewMailPage {
	WebDriver driver;
	@FindBy(name="Subject")
	private WebElement subjectField;
	@FindBy(tagName="body")
	private WebElement pageBody;
	@FindBy(className="b-toolbar__message")
	private WebElement saveMessage;
	@FindBy(css="#compose__header__content > div.compose__header__row.compose__header__row_to.compose__header__row_field.js-row-To > div.compose__header__field__box > div.compose__header__field.js-compose-labels.js-input.compose__labels.compose__labels_placehold-on-suggest.b-contact-container > textarea.js-input.compose__labels__input")
	private WebElement toField;
	@FindBy(xpath="//*[@id=\"b-nav_folders\"]/div/div[3]/a/span")
	WebElement draftsButton;
	@FindBy(className="b-nav__item_active")
	private WebElement inbox;
	@FindBy(css="#b-compose__sent > div > div:nth-child(1) > div > a:nth-child(2)")
	private WebElement toMain;
	@FindBy(css="#b-nav_folders > div > div:nth-child(2) > a")
	private WebElement toSended;

	public NewMailPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public NewMailPage fillMail(DataLoader testData){
		new Actions(driver).click(subjectField).sendKeys(testData.getSubject()).build().perform();
		new Actions(driver).click(toField).sendKeys(testData.getRecipient()).build().perform();
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(iframes.size() - 1));
		driver.findElement(By.id("tinymce")).sendKeys(testData.getBodyText());
		driver.switchTo().defaultContent();
		return this;
	}
	public NewMailPage saveDraft(){
		new Actions(driver).sendKeys(pageBody, Keys.chord(Keys.CONTROL,"s")).build().perform();
		return this;
	}
	public NewMailPage send(){
		new Actions(driver).sendKeys(pageBody, Keys.chord(Keys.CONTROL,Keys.ENTER)).build().perform();
		return this;
	}
	public boolean isSaved(){
		return driver.findElement(By.className("b-toolbar__message")).isDisplayed();
	}
	public boolean isSend(){
		return driver.findElement(By.className("message-sent")).isDisplayed();
	}
	public DraftsPage goToDrafts(){
		new Actions(driver).click(draftsButton).build().perform();
		return new DraftsPage(driver);
	}
	public Sended toSended(){
		new Actions(driver).click(toSended).build().perform();
		return new Sended(driver);
	}
	public void wait(int seconds){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	public MainPage toInbox(){
		new Actions(driver).click(inbox).build().perform();
		return new MainPage(driver);
	}
}
