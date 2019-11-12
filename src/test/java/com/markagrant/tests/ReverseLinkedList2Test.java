package com.markagrant.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReverseLinkedList2Test {

    private ReverseLinkedList2 reverse;

    @Before
    public void setUp() {
        reverse = new ReverseLinkedList2();
    }

    @Test
    public void can_reverse_empty_list() {
        assertTrue(reverse.reverseList(ReverseLinkedList2.empty, 0, 0).isTerminalNode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void m_must_be_zero_or_greater() {
        assertTrue(reverse.reverseList(ReverseLinkedList2.empty, -1, 0).isTerminalNode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void m_must_be_less_than_n() {
        assertTrue(reverse.reverseList(ReverseLinkedList2.empty, 5, 4).isTerminalNode());
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void n_must_be_less_than_list_length() {
        // current node implementation doesn't make this trivial without reviewing the whole list
    }

    @Test
    public void reverse_whole_list() {
        ReverseLinkedList2.Node  results = reverse.reverseList(ReverseLinkedList2.list(1, 2, 3, 4, 5), 0, 5);

        assertEquals(5, results.value);
        assertEquals(4, results.next.value);
        assertEquals(3, results.next.next.value);
        assertEquals(2, results.next.next.next.value);
        assertEquals(1, results.next.next.next.next.value);
    }
}