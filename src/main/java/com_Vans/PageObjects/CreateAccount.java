package com_Vans.PageObjects;

import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.WaitOperation;

public class CreateAccount {
	ElementOperations elemoperate = new ElementOperations();
	WaitOperation waits = new WaitOperation();
	public void ClickonCreate(String createbutton, String selempath) {
		elemoperate.scrolltoelem(selempath);
		elemoperate.Clicks(createbutton);	
		
	}
	public void applywait(String visiblepath) {
		waits.explicitwait(5, visiblepath);
		
	}
	public void mandatoryfields(String sendpath, String value) {
		elemoperate.formfill(sendpath, value);
	}
}
