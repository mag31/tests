package com.markagrant.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CloneGraph {
    public Graph clone(Graph graph) {
        return clone(new HashMap<>(), graph);
    }

    private Graph clone(Map<String, Graph> visitedNodes, Graph graph) {
        Graph clone = new Graph(graph.label);

        visitedNodes.put(graph.label, clone);

        graph.neighbours.forEach(n -> {
            if(!visitedNodes.containsKey(n.label)) {
                clone(visitedNodes, n);
            }
        });

        graph.neighbours.forEach(n -> {
            Graph cloneN = visitedNodes.get(n.label);
            clone.addNeighbour(cloneN);
        });

        return clone;
    }

    public boolean compare(Graph graph1, Graph graph2) {
        return compare(new HashMap<>(), graph1, graph2);
    }

    private boolean compare(Map<String, String> visitedNodes, Graph graph1, Graph graph2) {
        if(!graph1.label.equals(graph2.label))
            return false;

        if(graph1.neighbours.size() != graph2.neighbours.size())
            return false;

        visitedNodes.put(graph1.label, graph2.label);
        // iterate through sorted lists if we haven't visited a node go visit and check neighbours
        List<Graph> graph1Neighbours = graph1.neighbours.stream().sorted().collect(Collectors.toList());
        List<Graph> graph2Neighbours = graph2.neighbours.stream().sorted().collect(Collectors.toList());

        Iterator<Graph> it1 = graph1Neighbours.iterator();
        Iterator<Graph> it2 = graph2Neighbours.iterator();

        while(it1.hasNext() && it2.hasNext()) {
            Graph n1 = it1.next();
            Graph n2 = it2.next();
            boolean areSame = true;
            if(!visitedNodes.containsKey(n1.label))
                areSame = compare(visitedNodes, n1, n2);

            if(!areSame)
                return false;
        }

        return true;
    }
}
