package com.markagrant.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReverseLinkedList2Test {

    private ReverseLinkedList2 reverse;

    @Before
    public void setUp() {
        reverse = new ReverseLinkedList2();
    }

    @Test(expected = NullPointerException.class)
    public void list_cannot_be_null() {
        assertTrue(reverse.reverseList(null, 0, 0).isNull());
    }

    @Test
    public void can_reverse_empty_list() {
        assertTrue(reverse.reverseList(LinkedList.empty, 0, 0).isNull());
    }

    @Test(expected = IllegalArgumentException.class)
    public void m_must_be_zero_or_greater() {
        assertTrue(reverse.reverseList(LinkedList.empty, -1, 0).isNull());
    }

    @Test(expected = IllegalArgumentException.class)
    public void m_must_be_less_than_n() {
        assertTrue(reverse.reverseList(LinkedList.empty, 5, 4).isNull());
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void n_must_be_less_than_list_length() {
        // current node implementation doesn't make this trivial without reviewing the whole from
    }

    @Test
    public void reverse_whole_list() {
        LinkedList results = reverse.reverseList(LinkedList.from(0, 1, 2, 3, 4), 0, 4);

        assertTrue(results.compare(LinkedList.from(4, 3, 2, 1, 0)));
        assertTrue(reverse.i < 5);
    }

    @Test
    public void reverse_first_n_nodes() {
        LinkedList results = reverse.reverseList(LinkedList.from(0, 1, 2, 3, 4), 0, 3);

        assertTrue(results.compare(LinkedList.from(3, 2, 1, 0, 4)));
        assertTrue(reverse.i < 5);
    }

    @Test
    public void reverse_last_x_nodes() {
        LinkedList results = reverse.reverseList(LinkedList.from(0, 1, 2, 3, 4), 2, 4);

        assertTrue(results.compare(LinkedList.from(0, 1, 4, 3, 2)));
        assertTrue(reverse.i < 5);
    }

    @Test
    public void flip_nothing() {
        LinkedList results = reverse.reverseList(LinkedList.from(0, 1, 2, 3, 4), 3, 3);

        assertTrue(results.compare(LinkedList.from(0, 1, 2, 3, 4)));
        assertTrue(reverse.i < 5);
    }

    @Test
    public void reverse_part_of_list() {
        LinkedList results = reverse.reverseList(LinkedList.from(0, 1, 2, 3, 4), 1, 3);

        assertTrue(results.compare(LinkedList.from(0, 3, 2, 1, 4)));
        assertTrue(reverse.i < 5);
    }
}