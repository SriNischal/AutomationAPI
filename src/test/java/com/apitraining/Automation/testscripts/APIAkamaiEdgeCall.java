package com.apitraining.Automation.testscripts;


import org.testng.annotations.Test;

import com.apitraining.Automation.interfac.APIInterface;
import com.apitraining.Automation.utils.APIutil;



public class APIAkamaiEdgeCall {
	@Test
	public void akamaiedge() {
		APIInterface util = new APIutil();
		util.akamaiauth();
	}

}
