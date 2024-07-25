package com_Vans.PageObjects;

import com_Vans.Utilities.ElementOperations;

public class CreateAccount {
	ElementOperations elemoperate = new ElementOperations();
	public void ClickonCreate(String createbutton, String selempath) {
		elemoperate.scrolltoelem(selempath);
		elemoperate.Clicks(createbutton);	
		
	}
	public void applywait(String visiblepath) {
		elemoperate.explicitwait(5, visiblepath);
		
	}
	public void mandatoryfields(String sendpath, String value) {
		elemoperate.formfill(sendpath, value);
	}
	public void mandatorydropdown(String dopdownlocator, String visibletext) {
		elemoperate.dropdown_selection(dopdownlocator, visibletext);
	}
	public void date_selector() {
		elemoperate.Clicks("//*[@id=\"form-validate\"]/fieldset[1]/div[3]/div/button");
		elemoperate.dropdown_selection("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]", "Apr");
		elemoperate.dropdown_selection("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]", "1938");
		elemoperate.Clicks("//*[@id=\"ui-datepicker-div\"]/div[2]/button");
		elemoperate.scrolltoelem("//*[@id=\"form-validate\"]/fieldset[1]/div[8]/label/span/a");
	}
	public void check(String check) {
		elemoperate.explicitwait(5, "//*[@id=\"form-validate\"]/fieldset[1]/div[9]/label");
		elemoperate.select(check);
	}
	public void uncheck(String uncheck) {
		elemoperate.Deselect(uncheck);
	}
}
