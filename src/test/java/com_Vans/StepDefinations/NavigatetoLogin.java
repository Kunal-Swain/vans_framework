package com_Vans.StepDefinations;

import org.testng.Assert;
import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.WebdriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class NavigatetoLogin {

	ElementOperations elemoperate = new ElementOperations();
	WebdriverSetup driver = new WebdriverSetup();

	@Given("Go to the homepage URL")
	public void go_to_the_homepage_url() {
		driver.defaultPage("https://www.vans.com.sg/");
		elemoperate.explicitwait(5, "//*[@id=\"wpn-lightbox-close-newsletter\"]");
		elemoperate.Clicks("//*[@id=\"wpn-lightbox-close-newsletter\"]");
	}

	@Given("Click on sign-in button")
	public void click_on_sign_in_button() {
		elemoperate.Clicks("//*[@id=\"html-body\"]/div[2]/header/div[2]/div[2]/div[1]/ul/li[2]/a");
		elemoperate.explicitwait(5, "//*[@id=\"login-form\"]/fieldset/div[1]/div/div/div[1]/a");

	}

	@When("URL matched")
	public void url_matched() {
		String currentURL = elemoperate.GetURL();
		String expURL = "https://www.vans.com.sg/customer/account/login/";
		System.out.println(currentURL);
		Assert.assertEquals(currentURL, expURL);
	}
}
