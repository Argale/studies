package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.epam.seleniumTask.tests.DataLoader;

public class Sended {
	private WebDriver driver;
	public Sended(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean isSend(DataLoader dataLoader){
		long timeout=5;
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		boolean flag=false;
		List<WebElement> sendedList=driver.findElements(By.className("b-datalist__item__subj"));
	for (WebElement webElement : sendedList) {
		if(webElement.getText().contains(dataLoader.getSubject()))
			flag= true;
	}
	return flag;
	}
}
