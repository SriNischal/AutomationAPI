package com.apitraining.Automation.testscripts;

import org.testng.annotations.Test;


import com.apitraining.Automation.utils.APIutil;



public class APIDeleteCall{
	@Test
	public void deletecall() {
		APIutil util = new APIutil();
		util.apideletecall();
	}
}
