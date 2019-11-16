package com.markagrant.tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

        assertTrue(cloner.compare(original, clone));
    }

    @Test
    public void can_clone_graph_with_two_nodes() {
        Graph node1 = new Graph("node1");
        Graph node2 = new Graph("node2");

        Graph.link(node1, node2);

        CloneGraph cloner = new CloneGraph();
        Graph clone = cloner.clone(node1);

        assertEquals(node1.label, clone.label);
        assertEquals(node1.neighbours.get(0).label, clone.neighbours.get(0).label);

        assertTrue(cloner.compare(node1, clone));
    }

    @Test
    public void can_clone_graph_with_three_nodes() {
        Graph node1 = new Graph("node1");
        Graph node2 = new Graph("node2");
        Graph node3 = new Graph("node3");

        Graph.link(node1, node2);
        Graph.link(node1, node3);
        Graph.link(node2, node3);

        CloneGraph cloner = new CloneGraph();
        Graph clone = cloner.clone(node1);

        assertEquals(node1.label, clone.label);
        assertEquals(node1.neighbours.get(0).label, clone.neighbours.get(0).label);
        assertEquals(node1.neighbours.get(1).label, clone.neighbours.get(1).label);

        assertTrue(cloner.compare(node1, clone));
    }

    @Test
    public void can_clone_graph_with_four_nodes() {
        Graph node1 = new Graph("node1");
        Graph node2 = new Graph("node2");
        Graph node3 = new Graph("node3");
        Graph node4 = new Graph("node4");

        Graph.link(node1, node2);
        Graph.link(node1, node3);
        Graph.link(node1, node4);
        Graph.link(node2, node4);
        Graph.link(node3, node4);

        CloneGraph cloner = new CloneGraph();
        Graph clone = cloner.clone(node1);

        assertTrue(cloner.compare(node1, clone));
    }
}