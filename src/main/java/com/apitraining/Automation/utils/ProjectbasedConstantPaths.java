package com.apitraining.Automation.utils;

import java.io.File;

public class ProjectbasedConstantPaths {
	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;
    public final static String TEST_DATA = USER_HOME + File.separator + "src/main/resources"+ File.separator + "properties"
            + File.separator + "config.properties";
    public final static String JSON_DATA = USER_HOME + File.separator + "src/main/resources"+ File.separator + "properties"
            + File.separator + "testdata.json";
    public final static String requestcall= "Patch"; 
}
