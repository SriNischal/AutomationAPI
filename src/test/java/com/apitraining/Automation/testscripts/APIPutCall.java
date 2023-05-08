package com.apitraining.Automation.testscripts;

import org.testng.annotations.Test;

import com.apitraining.Automation.utils.APIutil;




public class APIPutCall {

	@Test
	public void putcall() {
		APIutil util = new APIutil();
		util.apiputcall();
	}

}
