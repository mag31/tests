package com.markagrant.tests;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public Graph clone(Graph graph) {
        return clone(new HashMap<>(), graph);
    }

    private Graph clone(Map<String, Graph> visitedNodes, Graph graph) {
        Graph clone = new Graph(graph.label);

        visitedNodes.put(graph.label, clone);

        graph.neighbours.forEach(n -> {
            Graph cloneN;
            if(!visitedNodes.containsKey(n.label)) {
                cloneN = clone(visitedNodes, n);
            } else {
                cloneN = visitedNodes.get(n.label);
            }
            Graph.link(clone, cloneN);
        });

        return clone;
    }
}
