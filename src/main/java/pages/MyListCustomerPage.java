package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class MyListCustomerPage {
	WebDriver driver;
	String before_Xpath = "//tbody//tr[";
	String after_xpath = "]//td[3]";
	String after_xpath_delete = "]//td[7]/a[2]";
	String after_xpath_profile = "]//td[7]/a[1]";
	//Full Xpath of the cell(Nth row) in 3rd column : tbody//tr[1]//td[3]
	//tbody//tr[1]//td[7]/a[2]
	//tbody/tr[3]/td[7]/a[1]

	public MyListCustomerPage(WebDriver driver) {
			this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]") WebElement ListCustomerTable;
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[2]/button[2]") WebElement Click_Ok_Element;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-success']") WebElement Add_Customer_on_List_Customer_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='foo_filter']") WebElement search_Customer_on_List_Customer_Element;

	public void validateListCustomerPage() {
		Assert.assertTrue(ListCustomerTable.isDisplayed(), "List Customer Page is not available");
	}
	public void validateIfNameIsInsertedAndDeleted(String insertedName) {
		for(int i=1; i<=10;i++) {
			String displayed_name = driver.findElement(By.xpath(before_Xpath+i+after_xpath)).getText();
			Assert.assertEquals(displayed_name, insertedName, "Inserted Name is not available");
			if(insertedName.equals(displayed_name)) {
				driver.findElement(By.xpath(before_Xpath+i+after_xpath_delete)).click();
				Click_Ok_Element.click();
				}
			break;
		}
		
		
	}
	public void clickAddCustomeronListCustomer() {
		Add_Customer_on_List_Customer_Element.click();
	}
		
	public void performSearchandcheckProfile(String insertedName) {
		search_Customer_on_List_Customer_Element.sendKeys(insertedName);
		for(int i = 1; i<=10; i++) {
			String name_from_list = driver.findElement(By.xpath(before_Xpath+i+after_xpath)).getText();
			if(insertedName.equals(name_from_list)) {
				driver.findElement(By.xpath(before_Xpath+i+after_xpath_profile)).click();
			}
		}
	}
	
}
