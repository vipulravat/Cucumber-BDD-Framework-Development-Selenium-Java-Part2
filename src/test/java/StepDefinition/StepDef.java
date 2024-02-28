package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {

	public WebDriver driver;
	
	public LoginPage loginpg;
	
	public AddNewCustomerPage addnewCustPg;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 
	 loginpg= new LoginPage(driver);
		addnewCustPg = new AddNewCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
	    loginpg.enterEmail(emailadd);
	    loginpg.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
	    loginpg.clickOnLoginButton();
	}

	//////login feature///////
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	   String actualTitle=driver.getTitle();
	  
	   if(actualTitle.equals(expectedTitle))
	   {
		   Assert.assertTrue(true);//pass
		
	   }
	   else
	   {
		   Assert.assertTrue(false);//fail
		   
	   }
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
	    loginpg.clickOnLogOutButton();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	    driver.quit();
	}
	
///Add new Customers///

@Then("User can view Dashboad")
public void user_can_view_dashboad() {

	String actualTitle = addnewCustPg.getPageTitle();
	String expectedTitle = "Dashboard / nopCommerce administration";
    
    if(actualTitle.equals(expectedTitle))
    {
    	Assert.assertTrue(true);
    }
    else
    {
    	Assert.assertTrue(false);
    }
}

@When("User click on customers Menu")
public void user_click_on_customers_menu() {
 addnewCustPg.clickOnCustomersMenu();
}

@When("click on customers Menu Item")
public void click_on_customers_menu_item() {
    addnewCustPg.clickOnCustomersMenuItem();
}

@When("click on Add new button")
public void click_on_add_new_button() {
  addnewCustPg.clickOnAddnew();
}

@Then("User can view Add new customer page")
public void user_can_view_add_new_customer_page() {
   String actualTitle = addnewCustPg.getPageTitle();
   String expectedTitle = "Add a new customer / nopCommerce administration";
  
   if(actualTitle.equals(expectedTitle))
   {
   	Assert.assertTrue(true);
   }
   else
   {
   	Assert.assertTrue(false);
   }
}


@When("User enter customer info")
public void user_enter_customer_info() {
    
	addnewCustPg.enterEmail("qaautomationvipulravat1@gmail.com");
	addnewCustPg.enterPassword("cucumber");
	addnewCustPg.enterFirstName("vipul");
	addnewCustPg.enterLastName("Ravat");
	addnewCustPg.enterGender("Male");
	addnewCustPg.enterDob("03/05/1998");
	addnewCustPg.enterCompanyName("vips Tech");
	addnewCustPg.enterAdminContent("Admin content");
	addnewCustPg.enterManagerOfVendor("Vendor 1");
	
}

@When("click on Save button")
public void click_on_save_button() {
    addnewCustPg.clickOnSave();
}

@Then("User can view confirmation message {string}")
public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
    
	String bodyTagText = driver.findElement(By.tagName("Body")).getText();
    if(bodyTagText.contains(expectedConfirmationMsg))
    {
    	Assert.assertTrue(true);
    }
    else
    {
    	Assert.assertTrue(false);
    }
}

}
