package com.markagrant.tests;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class ReverseLinkedList2Test {

    @Test
    public void can_create_class(){
        new ReverseLinkedList2();
    }

    @Test
    public void can_reverse_empty_list() {
        ReverseLinkedList2 reverse = new ReverseLinkedList2();

        LinkedList<Integer> results = reverse.reverseList(new LinkedList<>(), 0, 0);

        assertEquals(0, results.size());
    }
}