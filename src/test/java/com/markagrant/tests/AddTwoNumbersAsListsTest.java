package com.markagrant.tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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

        assertTrue(answer.compare(LinkedList.from(5)));
    }

    @Test
    public void can_add_single_digits_with_carry() {
        LinkedList a = LinkedList.from(7);
        LinkedList b = LinkedList.from(8);

        LinkedList answer = sum.add(a, b);

        assertTrue(answer.compare(LinkedList.from(5, 1)));
    }

    @Test
    public void can_add_double_digits() {
        LinkedList a = LinkedList.from(1,2);
        LinkedList b = LinkedList.from(4,6);

        LinkedList answer = sum.add(a, b);

        assertTrue(answer.compare(LinkedList.from(5, 8)));
    }

    @Test
    public void can_handle_multiple_carries() {
        LinkedList a = LinkedList.from(5,6,7);
        LinkedList b = LinkedList.from(9,7,5);

        LinkedList answer = sum.add(a, b);

        assertTrue(answer.compare(LinkedList.from(4,4,3,1)));
    }

    @Test
    public void a_longer_than_b() {
        LinkedList a = LinkedList.from(5,6,7,8);
        LinkedList b = LinkedList.from(9,7,5);

        LinkedList answer = sum.add(a, b);

        assertTrue(answer.compare(LinkedList.from(4,4,3,9)));
    }

    @Test
    public void b_longer_than_a() {
        LinkedList a = LinkedList.from(5,6,7);
        LinkedList b = LinkedList.from(9,7,5,4);

        LinkedList answer = sum.add(a, b);

        assertTrue(answer.compare(LinkedList.from(4,4,3,5)));
    }

    @Test
    public void extra_carry() {
        LinkedList a = LinkedList.from(5,6,7);
        LinkedList b = LinkedList.from(9,7,5,9);

        LinkedList answer = sum.add(a, b);

        assertTrue(answer.compare(LinkedList.from(4,4,3,0,1)));
    }

}