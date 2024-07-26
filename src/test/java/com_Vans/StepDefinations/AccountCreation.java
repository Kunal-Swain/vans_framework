package com_Vans.StepDefinations;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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

	@Given("Verify Page")
	public void verify_page() {
		elemoperate.scrolltoelem("//*[@id=\"send2\"]/span");
		elemoperate.Clicks("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[1]/div[4]/div/a/span");
	}

	@Given("Fill all mandatory fields")
	public void fill_all_mandatory_fields() {
		String visiblelabel = "//*[@id=\"maincontent\"]/div[1]/h1/span";
		elemoperate.explicitwait(5, visiblelabel);
		Sheet sheet = data.ExcelDyna();
		for (Row row : sheet) {
			String className = row.getCell(0).getStringCellValue();
			if ("fill_all_mandatory_fields".equalsIgnoreCase(className)) {
				String action = row.getCell(1).getStringCellValue();
				String xpath = row.getCell(2).getStringCellValue();
				String value = row.getCell(3).getStringCellValue();
				if ("Sendkeys".equalsIgnoreCase(action)) {
					elemoperate.formfill(xpath, value);
				}
				if ("Select".equalsIgnoreCase(action)) {
					elemoperate.dropdown_selection(xpath, value);
				}
			}
		}
	}

	@Given("Fill other fields")
	public void fill_other_fields() {

		elemoperate.Clicks("//*[@id=\"form-validate\"]/fieldset[1]/div[3]/div/button");
		elemoperate.dropdown_selection("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]", "Apr");
		elemoperate.dropdown_selection("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]", "1938");
		elemoperate.Clicks("//*[@id=\"ui-datepicker-div\"]/div[2]/button");
		elemoperate.scrolltoelem("//*[@id=\"form-validate\"]/fieldset[1]/div[8]/label/span/a");
	}

	@When("Check checkbox optional")
	public void check_checkbox_optional() {
		elemoperate.explicitwait(5, "//*[@id=\"form-validate\"]/fieldset[1]/div[9]/label");
		elemoperate.select("div.field:nth-child(15) > label:nth-child(2)");
		elemoperate.select("#consent_email_checkbox_label");
		elemoperate.Deselect("#remember-me-box > label:nth-child(2)");
	}

	@Then("Click on create account")
	public void click_on_create_account() {
//		driver.closeDriver();
	}

}
