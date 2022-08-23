package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.MyAddcustomerPage;
import pages.MyDashboardPage;
import pages.MyLoginPage;
import util.MyBrowserFactory;

@Test
public class MyaddCustomerTest {

	WebDriver driver;

	public void validateAddContactsPage() throws InterruptedException {
		driver = MyBrowserFactory.init();
				
		MyLoginPage loginpage = PageFactory.initElements(driver, MyLoginPage.class);
		loginpage.insertUsername("demo@techfios.com");
		loginpage.insertPassword("abc123");
		loginpage.clickSigninButton();

		MyDashboardPage dashboardpage = PageFactory.initElements(driver, MyDashboardPage.class);
		dashboardpage.validateDashboardPage("Dashboard- iBilling");
		dashboardpage.clickCustomerElement();
		dashboardpage.clickAddCustomerElement();

		MyAddcustomerPage addcustomerpage = PageFactory.initElements(driver, MyAddcustomerPage.class);
		addcustomerpage.validateAddCustomerPage1("Contacts - iBilling");
		addcustomerpage.insertFullname("Hello");
		addcustomerpage.insertCompany("Amazon");
		addcustomerpage.insertEmail("abyz@abd.com");
		addcustomerpage.insertPhone("007");
		addcustomerpage.insertCity("fsdfkcity");
		addcustomerpage.insertState("state");
		addcustomerpage.insertCountry("United States");
		addcustomerpage.insertAddress("habuemd");
		addcustomerpage.insertZip("111111");
		addcustomerpage.clickSubmit();
		
		addcustomerpage.ValidateProfilePage1("Contacts");
		dashboardpage.clickListCustomerElement();

	}
}
