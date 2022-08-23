package pages;

import javax.swing.text.html.parser.TagElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MyAddcustomerPage extends BasePage {
	WebDriver driver;
	public String insertedName;

	public MyAddcustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='account']") WebElement Fullname_Element;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']") WebElement Company_Dropdown_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement Email_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']") WebElement Phone_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement Address_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement City_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='state']") WebElement State_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']") WebElement Zip_Element;
	@FindBy(how = How.XPATH, using = "//select[@id='country']") WebElement Country_Dropdown_Element;
	@FindBy(how = How.XPATH, using = "//select[@id='tags']") WebElement Tags_Element;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']") WebElement Submit_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement Contacts_Header_Element;

	

	public void validateAddCustomerPage1(String validateText) {
		Assert.assertEquals(driver.getTitle(), validateText, "AddCustomerPage not available");
	}
	public void ValidateProfilePage(String visibleText) {
		
	}
	public String insertFullname(String fullname) {
		insertedName = fullname+generageRandomNumber(999);
		Fullname_Element.sendKeys(insertedName);
		return insertedName;
	}
	public void insertCompany(String visibleText) {
		selectdropdownVisibleText(Company_Dropdown_Element, visibleText);
	}
	public void insertEmail(String email) {
		Email_Element.sendKeys(generageRandomNumber(999)+ email);
	}
	public void insertPhone(String phone) {
		Phone_Element.sendKeys(generageRandomNumber(999)+ phone);
	}
	public void insertCity(String city) {
		City_Element.sendKeys(city);
	}
	public void insertState(String state) {
		State_Element.sendKeys(state);
	}
	public void insertAddress(String address) {
		Address_Element.sendKeys(address);
	}
	public void insertCountry(String visibleText) {
		selectdropdownVisibleText(Country_Dropdown_Element, visibleText);
	}
	public void insertZip(String zip) {
		Zip_Element.sendKeys(zip);
	}
	public void insertTags(String[] tags) {
		
		Tags_Element.sendKeys(tags);
		pressEnter(driver);
//		for(String item:tags) {
//			Tags_Element.sendKeys(item);
//		pressEnter(driver);
		}		
	
	public void clickSubmit() {
		Submit_Element.click();
	}
	public void ValidateProfilePage1(String visibleText) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(Contacts_Header_Element.getText(), visibleText, "Profile page not found");
		
	}
	
	
	
	
}
