package com.apitraining.Automation.testscripts;

import org.testng.annotations.Test;

import com.apitraining.Automation.utils.APIutil;



public class APIBasicAuthCall {

	@Test
	public void basicauth() {
		APIutil util = new APIutil();
		util.basicauth();

	}

}
