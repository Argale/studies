package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Sended extends BasicMail{
	public Sended(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public boolean isSend(){
		long timeout=5;
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		boolean flag=false;
		List<WebElement> sendedList=driver.findElements(By.className("b-datalist__item__subj"));
	for (WebElement webElement : sendedList) {
		if(webElement.getText().contains(inputContent.getSubject()))
			flag= true;
	}
	return flag;
	}
}
