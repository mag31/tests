package com.markagrant.tests;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegularExpression2Test {

    @Test
    public void can_match_simple_text() {
        RegularExpression2 reg = new RegularExpression2();
        assertTrue(reg.isMatch("a", "a"));
    }

    @Test
    public void can_match_with_no_entire_string() {
        RegularExpression2 reg = new RegularExpression2();
        assertFalse(reg.isMatch("aa", "a"));
    }

    @Test
    public void aa_matches_aa() {
        RegularExpression2 reg = new RegularExpression2();
        assertTrue(reg.isMatch("aa", "aa"));
    }

    @Test
    public void aa__no_match_aaa() {
        RegularExpression2 reg = new RegularExpression2();
        assertFalse(reg.isMatch("aaa", "aa"));
    }

    @Test
    public void a_star__matches_aa() {
        RegularExpression2 reg = new RegularExpression2();
        assertTrue(reg.isMatch("aa", "a*"));
    }

    @Test
    public void dot_star__matches_aa() {
        RegularExpression2 reg = new RegularExpression2();
        assertTrue(reg.isMatch("aa", ".*"));
    }

    @Test
    public void dot_star__matches_ab() {
        RegularExpression2 reg = new RegularExpression2();
        assertTrue(reg.isMatch("ab", ".*"));
    }

    @Test
    public void c_star_a_star_b__matches_cab() {
        RegularExpression2 reg = new RegularExpression2();
        assertTrue(reg.isMatch("cab", "c*a*b"));
    }

    @Test
    public void dot_star_dot_star_dot__matches_cab() {
        RegularExpression2 reg = new RegularExpression2();
        assertTrue(reg.isMatch("cab", ".*.*."));
    }

    @Test
    public void dot_star_dot_star__matches_cab() {
        RegularExpression2 reg = new RegularExpression2();
        assertTrue(reg.isMatch("cab", ".*.*"));
    }
}