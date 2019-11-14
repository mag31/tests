package com.markagrant.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CloneGraphTest {

    @Test
    public void can_clone_graph() {
        Graph original = new Graph();
        
        CloneGraph cloner = new CloneGraph();
        Graph clone = cloner.clone(original);

        assertTrue(clone.checkClone(original));
    }
}