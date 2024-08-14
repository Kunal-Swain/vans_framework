package com_Vans.StepDefinations;

import com_Vans.PageObjects.BaseClass;
import com_Vans.Utilities.Data;
import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.WebdriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreation {
	ElementOperations elemoperate = new ElementOperations();
	WebdriverSetup driver = new WebdriverSetup();
	Data data = new Data();
	String dynamic = "";

	@Given("Verify Page")
	public void verify_page() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@Given("Fill all mandatory fields")
	public void fill_all_mandatory_fields() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@Given("Fill other fields")
	public void fill_other_fields() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@When("Check checkbox optional")
	public void check_checkbox_optional() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@Then("Click on create account")
	public void click_on_create_account() {
		driver.closeDriver();
	}

}
