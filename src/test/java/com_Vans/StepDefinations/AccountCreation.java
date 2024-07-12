package com_Vans.StepDefinations;
import com_Vans.PageObjects.CreateAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreation {
	CreateAccount creation = new CreateAccount();
	@Given("Verify Page")
	public void verify_page() {
		creation.ClickonCreate("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[1]/div[4]/div/a", "//*[@id=\"send2\"]");
	}

	@Given("Fill all mandatory fields")
	public void fill_all_mandatory_fields() {
		String visiblelabel = "//*[@id=\"maincontent\"]/div[1]/h1/span";
		creation.applywait(visiblelabel);
		String[] fname = {"//*[@id=\"firstname\"]","Automation 1"};
		String[] lname = {"//*[@id=\"lastname\"]","test"};
		String[] email = {"//*[@id=\"email_address\"]","emailmaster@mailinator.com"};
		String[] pass = {"//*[@id=\"password\"]","Test@123"};
		String[] cpass = {"//*[@id=\"password-confirmation\"]","Test@123"};
//		String[] lname = {"",""};
		creation.mandatoryfields(fname[0], fname[1]);
		creation.mandatoryfields(lname[0], lname[1]);
		creation.mandatoryfields(email[0], email[1]);
		creation.mandatoryfields(pass[0], pass[1]);
		creation.mandatoryfields(cpass[0], cpass[1]);
	}

	@Given("Fill other fields")
	public void fill_other_fields() {
	    
	}

	@When("Check checkbox optional")
	public void check_checkbox_optional() {
	   
	}

	@Then("Click on create account")
	public void click_on_create_account() {
	    
	}


}
