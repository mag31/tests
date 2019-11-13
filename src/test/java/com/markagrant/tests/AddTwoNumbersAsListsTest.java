package com.markagrant.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddTwoNumbersAsListsTest {

    private AddTwoNumbersAsLists sum;

    @Before
    public void setUp() {
        sum = new AddTwoNumbersAsLists();
    }

    @Test(expected = NullPointerException.class)
    public void error_if_a_is_null() {
        sum.add(null, LinkedList.from(1));
    }

    @Test(expected = NullPointerException.class)
    public void error_if_b_is_null() {
        sum.add(LinkedList.from(1), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void error_if_a_is_empty() {
        sum.add(LinkedList.empty, LinkedList.from(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void error_if_b_is_empty() {
        sum.add(LinkedList.from(1), LinkedList.empty);
    }

    @Test
    public void can_add_single_digits() {
        LinkedList a = LinkedList.from(1);
        LinkedList b = LinkedList.from(4);

        LinkedList answer = sum.add(a, b);

        assertEquals(5, answer.value);
        assertTrue(answer.next.isNull());
    }

    @Test
    public void can_add_single_digits_with_carry() {
        LinkedList a = LinkedList.from(7);
        LinkedList b = LinkedList.from(8);

        LinkedList answer = sum.add(a, b);

        assertEquals(5, answer.value);
        assertEquals(1, answer.next.value);
        assertTrue(answer.next.next.isNull());
    }

    @Ignore
    @Test
    public void can_add_numbers() {
        LinkedList a = LinkedList.from(1,2,3);
        LinkedList b = LinkedList.from(4,5,6);

        LinkedList answer = sum.add(a, b);

        assertEquals(5, answer.value);
        assertEquals(7, answer.next.value);
        assertEquals(9, answer.next.next.value);
    }
}