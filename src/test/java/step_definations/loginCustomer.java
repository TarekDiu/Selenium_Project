package step_definations;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class loginCustomer extends Base {
	//int rowNum; 
	String userId;
	String password;
	
	@Given("I am in landing page")
	public void i_am_in_landing_page_https_dailyneed_prodevsltd_xyz() {
		
		navigateURL(host);
	    
	}

	@When("I Click on Login menu")
	public void i_Click_on_Login_menu() {
		
		click( By.xpath("//a[@class='sign-in-btn']//span[contains(text(),'সাইন ইন')]") );
	    
	}

	@Then("Enter User Id as {string}")
	public void enter_User_Id_as(String userId) {
		
		sendkeys(By.xpath("//input[@id='email_phone']"), userId );
	    
	}

	@Then("I Enter Password as {string}")
	public void i_Enter_Password_as(String password) {
		
		sendkeys(By.xpath("//input[@id='password']"), password);
	   
	}

	@Then("I Click on Login Button")
	public void i_Click_on_Login_Button() {
		
		click( By.xpath("//button[@class='btn w-100 sign-in-btn']")); 
	}
	
	@Then("Verify the home page")
	public void verify_the_home_page() {
	   
	    
	}
	
	@Then("Verify the login error message {string}")
	public void verify_the_login_error_message(String error_message) {
		
	String actualerrormessage =  getElementText(By.xpath("//span[contains(text(),'দুঃখিত, আপনি ভুল ই-মেইল/ফোন নাম্বার/পাসওয়ার্ড দিয়ে')]"));
	 assertEquals(actualerrormessage, error_message);
	 System.out.println("Your assertion is completely Done");
	   
	}

	

}
