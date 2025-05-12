package step_definations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidLoginExelFile extends Base {
	
	int rownum; 
	String Emailtest;
	String Passwordtest;
	String Errortest;

	@Given("I am in website homepage")
	public void i_am_in_website_homepage() {
		
		navigateURL(host);
		
	}

	@When("I clicked the সাইন ইন Button")
	public void i_clicked_the_সাইন_ইন_Button() {
		click( By.xpath("//a[@class='sign-in-btn']//span[contains(text(),'সাইন ইন')]") );
	}

	
	@Then("I Put it my Email in Email field {string}")
	public void i_Put_it_my_Email_in_Email_field(String rownumber) {
		
		rownum = Integer.parseInt(rownumber); //firstly conver integer to string cs cucumber support string
		Emailtest = testData.get(rownum).get("Email"); //then i put it my data in the excelfile in the own variblae declare
		sendkeys(By.xpath("//input[@id='email_phone']"), Emailtest );
		   
	}

	@Then("I Put it my  Password in Password field")
	public void i_Put_it_my_Password_in_Password_field() {
		Passwordtest = testData.get(rownum).get("Password");
		sendkeys(By.xpath("//input[@id='password']"), Passwordtest);
		
	}

	@Then("I click the সাবমিট Button")
	public void i_click_the_সাবমিট_Button() {
		click( By.xpath("//button[@class='btn w-100 sign-in-btn']")); 
		
		
	}

	@Then("I log in my profile successfully error")
	public void i_log_in_my_profile_successfully_error() {
		
		Errortest = testData.get(rownum).get("Error");
		String actualErrMsg =  getElementText(By.xpath("//span[contains(text(),'দুঃখিত, আপনি ভুল ই-মেইল/ফোন নাম্বার/পাসওয়ার্ড দিয়ে')]"));
		assertEquals(Errortest , actualErrMsg);
		
	}

}
