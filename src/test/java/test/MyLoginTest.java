package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.MyDashboardPage;
import pages.MyLoginPage;
import util.MyBrowserFactory;

public class MyLoginTest {
	WebDriver driver;
	

	@Test
	public void validusershouldBeAbleToLogin() {
		driver = MyBrowserFactory.init();
		
		MyLoginPage loginpage = PageFactory.initElements(driver, MyLoginPage.class);
		loginpage.insertUsername("demo@techfios.com");
		loginpage.insertPassword("abc123");
		loginpage.clickSigninButton();
		
		MyDashboardPage dashboard = PageFactory.initElements(driver, MyDashboardPage.class);
		dashboard.validateDashboardPage("Dashboard- iBilling");
		
		
		
		
	}
}
