package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyLoginPage {

	WebDriver driver;
	public MyLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH,using = "//input[@id = 'username']") WebElement username_Element;
	@FindBy(how = How.XPATH, using = "//input[@id = 'password']") WebElement password_Element;
	@FindBy(how = How.XPATH, using = "//button[@name = 'login']") WebElement Signin_Button_Element;
	
	public void insertUsername(String username) {
			username_Element.sendKeys(username);
	}
	public void insertPassword(String password) {
		password_Element.sendKeys(password);
	}
	public void clickSigninButton() {
		Signin_Button_Element.click();
	}
	
}
