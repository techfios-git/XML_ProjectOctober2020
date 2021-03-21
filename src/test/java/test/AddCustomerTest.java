package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.CustomerSummary;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	
	WebDriver driver;
	
	
	//@Test
	@Parameters({"username", "password", "fullName", "company", "email", "phone", "address", "city", "state", "zip", "country"})
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String company, String email, String phone, String address, String city, String state, String zip, String country) {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.chooseCompanyOption(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhoneNumber(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.chooseCountryOption(country);
		addCustomerPage.clickSubmitButton();
		
		CustomerSummary customerSummary = PageFactory.initElements(driver, CustomerSummary.class);
		customerSummary.validateCustomerSummary();
		
		dashboardPage.clickListCustomerButton();
		addCustomerPage.verifyEnteredNameAndDelete();

	}
	
	@Test
	@Parameters({"username", "password", "fullName", "company", "email", "phone", "address", "city", "state", "zip", "country"})
	public void userShouldBeAbleToUseSearchbarOnListCustomer(String userName, String password, String fullName, String company, String email, String phone, String address, String city, String state, String zip, String country) {
		
		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignInButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerButton();
		//dashboardPage.clickAddCustomerButton();
		dashboardPage.clickListCustomerButton();
		
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCustomer();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.chooseCompanyOption(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhoneNumber(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.chooseCountryOption(country);
		addCustomerPage.clickSubmitButton();
		
		CustomerSummary customerSummary = PageFactory.initElements(driver, CustomerSummary.class);
		customerSummary.validateCustomerSummary();
		
		dashboardPage.clickListCustomerButton();
		addCustomerPage.enterNameOnSearchBarOnListCustomer();
		addCustomerPage.TestListCustomerSummaryButton();
		
		customerSummary.validateCustomerSummary();

		BrowserFactory.tearDown();
		
		
	}
	
	

}
