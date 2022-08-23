package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MyAddcustomerPage;
import pages.MyDashboardPage;
import pages.MyListCustomerPage;
import pages.MyLoginPage;
import util.MyBrowserFactory;

public class MyListCustomerTest {

	WebDriver driver;
	String insertedName;
	MyLoginPage loginpage;
	MyDashboardPage dashboardpage;
	MyAddcustomerPage addcustomerpage;
	MyListCustomerPage listcustomerpage;
	
	@Test
	@Parameters({"username","password","fullname","company","email","phone","city","state","country","address","zip"})
	public void validateCustomerIsAddedAndDeleteFunctionIsWorking(String UserName, String Password,String FullName,String Company, String Email, String Phone, String City, String State, String Country, String Address, String Zip) throws InterruptedException {
		driver = MyBrowserFactory.init();
		
		loginpage = PageFactory.initElements(driver, MyLoginPage.class);
		loginpage.insertUsername(UserName);
		loginpage.insertPassword(Password);
		loginpage.clickSigninButton();

		dashboardpage = PageFactory.initElements(driver, MyDashboardPage.class);
		dashboardpage.validateDashboardPage("Dashboard- iBilling");
		dashboardpage.clickCustomerElement();
		dashboardpage.clickAddCustomerElement();
		
		addcustomerpage = PageFactory.initElements(driver, MyAddcustomerPage.class);
		addcustomerpage.validateAddCustomerPage1("Contacts - iBilling");
		insertedName = addcustomerpage.insertFullname(FullName);
		addcustomerpage.insertCompany(Company);
		addcustomerpage.insertEmail(Email);
		addcustomerpage.insertPhone(Phone);
		addcustomerpage.insertCity(City);
		addcustomerpage.insertState(State);
		addcustomerpage.insertCountry(Country);
		addcustomerpage.insertAddress(Address);
		addcustomerpage.insertZip(Zip);
		
		addcustomerpage.clickSubmit();
		addcustomerpage.ValidateProfilePage1("Contacts");
		dashboardpage.clickListCustomerElement();
		
		listcustomerpage = PageFactory.initElements(driver, MyListCustomerPage.class);
		listcustomerpage.validateListCustomerPage();
		listcustomerpage.validateIfNameIsInsertedAndDeleted(insertedName);
		listcustomerpage.clickAddCustomeronListCustomer();
		insertedName = addcustomerpage.insertFullname(FullName);
		addcustomerpage.insertCompany(Company);
		addcustomerpage.insertEmail(Email);
		addcustomerpage.insertPhone(Phone);
		addcustomerpage.insertCity(City);
		addcustomerpage.insertState(State);
		addcustomerpage.insertCountry(Country);
		addcustomerpage.insertAddress(Address);
		addcustomerpage.insertZip(Zip);
		addcustomerpage.clickSubmit();
		
		addcustomerpage.ValidateProfilePage1("Contacts");
		dashboardpage.clickListCustomerElement();
		
		listcustomerpage.performSearchandcheckProfile(insertedName);
		
		MyBrowserFactory.teardown();
		
		
	}
}
