package com.apitraining.Automation.testscripts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class hamcrest {
    
    @Test
    public void testStringMatchers() {
        String str = "Hello, world!";
        
        assertThat(str, equalTo("Hello, world!"));
        assertThat(str, startsWith("Hello"));
        assertThat(str, endsWith("world!"));
        assertThat(str, containsString("lo,"));
        assertThat(str, not(emptyString()));
    }
    
    @Test
    public void testCollectionMatchers() {
        List<String> list = Arrays.asList("foo", "bar", "baz");
        
        assertThat(list, hasSize(3));
        assertThat(list, contains("foo", "bar", "baz"));
        assertThat(list, not(contains("qux")));
    }
}
