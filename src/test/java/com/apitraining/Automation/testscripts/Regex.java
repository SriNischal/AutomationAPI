package com.apitraining.Automation.testscripts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class Regex {
	private static final Pattern p = Pattern.compile("^([a-zA-Z]+)");
	@Test
	public void regexpression() {
	    // create matcher for pattern p and given string
	    //Matcher m = p.matcher("Testing123Testing");
		Matcher m = p.matcher("Apple");

	    // if an occurrence if a pattern was found in a given string...
	    if (m.matches()) {
	        // ...then you can use group() methods.
	        System.out.println(m.group(0)); // whole matched expression
	        //.out.println(m.group(1)); // first expression from round brackets (Testing)
	        //System.out.println(m.group(2)); // second one (123)
	        //System.out.println(m.group(3)); // third one (Testing)
	    }
	}

}
