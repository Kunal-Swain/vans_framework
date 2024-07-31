package com_Vans.StepDefinations;

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
		elemoperate.explicitwait("//*[@id=\"wpn-lightbox-close-newsletter\"]", 5);
		elemoperate.Clicks("//*[@id=\"wpn-lightbox-close-newsletter\"]");
		elemoperate.Conditionclick("//*[@id=\"html-body\"]/aside/div/div/div[2]/button[1]");
		
	}

	@Given("Click on sign-in button")
	public void click_on_sign_in_button() {
		elemoperate.Clicks("//*[@id=\"html-body\"]/div[3]/header/div[2]/div[2]/div[1]/ul/li[2]/a");
		elemoperate.explicitwait("//*[@id=\"login-form\"]/fieldset/div[1]/div/div/div[1]/a", 5);

	}

	@When("URL matched")
	public void url_matched() {
		String currentURL = elemoperate.GetURL();
		String expURL = "https://www.vans.com.sg/customer/account/login/";
		elemoperate.asserted(currentURL, expURL);
	}
}
