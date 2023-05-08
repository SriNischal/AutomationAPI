package com.apitraining.Automation.testscripts;

import org.testng.annotations.Test;

import com.apitraining.Automation.utils.APIutil;



public class APIAWSAuthCall {

	@Test
	public void awsauth() {
		APIutil util = new APIutil();
		util.awsauth();
	}

}
