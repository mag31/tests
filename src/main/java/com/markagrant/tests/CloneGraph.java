package com.markagrant.tests;

import java.util.HashSet;
import java.util.Set;

public class CloneGraph {
    public Graph clone(Graph graph) {
        Set<String> visitedNodes = new HashSet<>();

        return new Graph(graph.label);
    }
}
