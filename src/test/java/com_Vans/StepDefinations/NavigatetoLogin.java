package com_Vans.StepDefinations;
import org.testng.Assert;

import com_Vans.PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigatetoLogin {
	 LoginPage initiate = new LoginPage();
	@Given("Go to the homepage URL")
	public void go_to_the_homepage_url() throws Throwable {
	   
	    initiate.LoggedIn();
	    initiate.clickonad("//*[@id=\"wpn-lightbox-close-newsletter\"]");
	}
	@Given("Click on sign-in button")
	public void click_on_sign_in_button() {
		
		initiate.signin("//*[@id=\"html-body\"]/div[2]/header/div[2]/div[2]/div[1]/ul/li[2]/a", "//*[@id=\"login-form\"]/fieldset/div[1]/div/div/div[1]/a");
	}
	@When("URL matched")
	public void url_matched() {
		String currentURL = initiate.urlMatch();
		String expURL = "https://www.vans.com.sg/customer/account/login/";
		Assert.assertEquals(currentURL,expURL);
	}
	@Then("Pass and close the browser")
	public void pass_and_close_the_browser() {
		initiate.closeDriver();
	}
}
