package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class MyDashboardPage {

	WebDriver driver;
	
	public MyDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]") WebElement Customer_Element;
	@FindBy(how = How.XPATH, using ="//a[contains(text(),'Add Customer')]") WebElement Add_Customer_Element;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customers')]") WebElement List_Customer_Element;
	
	public void validateDashboardPage(String validationText) {
		Assert.assertEquals(driver.getTitle(), validationText, "DashBoard page not Available");
	}
	
	public void clickCustomerElement() {
		Customer_Element.click();
	}
	public void clickAddCustomerElement() {
		Add_Customer_Element.click();
	}
	
	public void clickListCustomerElement() {
		List_Customer_Element.click();
	}
}
