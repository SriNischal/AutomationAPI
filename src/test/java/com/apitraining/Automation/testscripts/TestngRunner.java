package com.apitraining.Automation.testscripts;

import org.testng.annotations.Test;


import com.apitraining.Automation.utils.TestngUtil;



public class TestngRunner {
	@Test
	public void patchcall() {
		TestngUtil util = new TestngUtil();
		util.beforeSuite();
		util.beforeTest();
		util.test();
		util.afterTest();
		util.afterSuite();
	}
}
