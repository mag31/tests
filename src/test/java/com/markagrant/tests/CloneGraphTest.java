package com.markagrant.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CloneGraphTest {

    @Test
    public void can_clone_empty_graph() {
        Graph original = new Graph();

        CloneGraph cloner = new CloneGraph();
        Graph clone = cloner.clone(original);

        assertTrue(clone.checkClone(original));
    }

    @Test
    public void can_clone_graph_with_single_node() {
        Graph original = new Graph(new Graph.Node("node"));

        CloneGraph cloner = new CloneGraph();
        Graph clone = cloner.clone(original);

        assertTrue(clone.checkClone(original));
    }
}