package com_Vans.StepDefinations;
import org.testng.Assert;

import com_Vans.PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigatetoLogin {
	@Given("Go to the homepage URL")
	public void go_to_the_homepage_url() throws Throwable {
	    LoginPage initiate = new LoginPage();
	    initiate.LoggedIn();
	    LoginPage adclick = new LoginPage();
	    adclick.clickonad("//*[@id=\"wpn-lightbox-close-newsletter\"]");
	}
	@Given("Click on sign-in button")
	public void click_on_sign_in_button()throws Throwable {
		LoginPage signin = new LoginPage();
		signin.signin("//*[@id=\"html-body\"]/div[2]/header/div[2]/div[2]/div[1]/ul/li[2]/a");
	}
	@When("URL matched")
	public void url_matched() {
		LoginPage getcurrentURL = new LoginPage();
		String currentURL = getcurrentURL.urlMatch();
		String expURL = "https://www.vans.com.sg/customer/account/login/";
		Assert.assertEquals(currentURL,expURL);
	}
	@Then("Pass and close the browser")
	public void pass_and_close_the_browser() {
		LoginPage closedriver = new LoginPage();
		closedriver.closeDriver();
	}
}
