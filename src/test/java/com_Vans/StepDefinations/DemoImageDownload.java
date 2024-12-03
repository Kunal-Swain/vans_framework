package com_Vans.StepDefinations;

import com_Vans.PageObjects.BaseClass;
import com_Vans.Utilities.Data;
import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.WebdriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoImageDownload {
	ElementOperations elemoperate = new ElementOperations();
	WebdriverSetup driver = new WebdriverSetup();
	Data data = new Data();
	String dynamic = "";

	@Given("go to the url of vans s3")
	public void go_to_the_url_of_vans_s3() {
		driver.defaultPage("https://dam.vans.com/");
	}

	@Given("login with valid username and password")
	public void login_with_valid_username_and_password() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@When("go to catalogs")
	public void go_to_catalogs() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@When("click on first product")
	public void click_on_first_product() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@When("click on download button")
	public void click_on_download_button() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@Then("click on standard download")
	public void click_on_standard_download() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

}
