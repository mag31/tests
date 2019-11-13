package com.markagrant.tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbersAsListsTest {

    private AddTwoNumbersAsLists sum;
    @Before
    public void setUp() {
        sum = new AddTwoNumbersAsLists();
    }

    @Test
    public void can_create_class() {
        LinkedList a = LinkedList.from(1,2,3);
        LinkedList b = LinkedList.from(4,5,6);

        LinkedList answer = sum.add(a, b);
        
        assertEquals(5, answer.value);
        assertEquals(7, answer.next.value);
        assertEquals(9, answer.next.next.value);
    }
}