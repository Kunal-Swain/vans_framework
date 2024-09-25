package com_Vans.StepDefinations;

import com_Vans.PageObjects.BaseClass;
import com_Vans.Utilities.Data;
import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.WebdriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Categories {
	ElementOperations elemoperate = new ElementOperations();
	WebdriverSetup driver = new WebdriverSetup();
	Data data = new Data();
	String dynamic = "";
	
	@Given("Go to the URL")
	public void go_to_the_url() {
		driver.defaultPage("https://vanssgstg.ada-asia.my/");
	}

	@When("Take screeshot of homepage")
	public void take_screeshot_of_homepage() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@Then("click on Main Menu Content")
	public void click_on_main_menu_content() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}

	@When("Redirect to main navigations")
	public void redirect_to_main_navigations() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}
	
	@Then("Click on each New Arrival Link")
	public void click_on_each_New_Arrival_Link() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}
	
	@Then("Close the window")
	public void close_the_window() {
		dynamic = elemoperate.getCurrentMethodName();
		BaseClass run = new BaseClass();
		run.basics(dynamic);
	}
}
