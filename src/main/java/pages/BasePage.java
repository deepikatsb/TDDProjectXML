package pages;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public int generageRandomNumber(int boundary) {
		Random rand = new Random();
		int randomNum = rand.nextInt(boundary);
		return randomNum;
	}
	public void selectdropdownVisibleText(WebElement DropDownElement, String visibleText) {
		Select sel = new Select(DropDownElement);
		sel.selectByVisibleText(visibleText);
		
	}
	public void pressEnter(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
}
