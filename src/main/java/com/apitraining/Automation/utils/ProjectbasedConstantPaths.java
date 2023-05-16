package com.apitraining.Automation.utils;

import java.io.File;

public class ProjectbasedConstantPaths {
	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;
    public final static String TEST_DATA = USER_HOME + File.separator + "src/main/resources"+ File.separator + "properties"
            + File.separator + "config.properties";
    public final static String JSON_DATA = USER_HOME + File.separator + "src/main/resources"+ File.separator + "properties"
            + File.separator + "testdata.json";
    public final static String[] requestcall= {"Post","Get"}; 
    public final static String title = "Apple";
    public final static String pattern = "([a-zA-Z0-9.*@]+)";
    public final static String Json_postwiremockData = USER_HOME + File.separator + "src/main/resources" + File.separator
            + "properties" + File.separator + "posttestdata.json";
    public final static String Json_putwiremockData = USER_HOME + File.separator + "src/main/resources" + File.separator
            + "properties" + File.separator + "puttestdata.json";
    public final static String Json_patchwiremockData = USER_HOME + File.separator + "src/main/resources" + File.separator
            + "properties" + File.separator + "patchtestdata.json";
}
