package test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.MyAddcustomerPage;
import pages.MyDashboardPage;
import pages.MyLoginPage;
import util.MyBrowserFactory;

public class MyDashboardTest {

	WebDriver driver ;
	@Test
	public void validateUserShouldBeAbleToGoToAddCustomerPage() {
		driver = MyBrowserFactory.init();
		
		MyLoginPage loginpage = PageFactory.initElements(driver, MyLoginPage.class);
		loginpage.insertUsername("demo@techfios.com");
		loginpage.insertPassword("abc123");
		loginpage.clickSigninButton();
		
		MyDashboardPage dashboard = PageFactory.initElements(driver, MyDashboardPage.class);
		dashboard.validateDashboardPage("Dashboard- iBilling");
		dashboard.clickCustomerElement();
		dashboard.clickAddCustomerElement();
		
		MyAddcustomerPage addcustomerpage = PageFactory.initElements(driver, MyAddcustomerPage.class);
		addcustomerpage.validateAddCustomerPage1("Contacts - iBilling");
	}
}
