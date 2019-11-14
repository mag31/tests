package com.markagrant.tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CloneGraphTest {

    @Test(expected=NullPointerException.class)
    public void can_clone_empty_graph() {
        new Graph(null);
    }

    @Test
    public void can_clone_graph_with_single_node() {
        Graph original = new Graph("node");

        CloneGraph cloner = new CloneGraph();
        Graph clone = cloner.clone(original);

        assertEquals(original.label, clone.label);
        assertEquals(original.neighbours.size(), clone.neighbours.size());
    }
}