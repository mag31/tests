package com.markagrant.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegularExpression2Test {

    @Test
    public void can_match_simple_text() {
        RegularExpression2 reg = new RegularExpression2();
        assertTrue(reg.isMatch("a", "a"));
    }
}