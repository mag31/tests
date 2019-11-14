package com.markagrant.tests;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {
    public Graph clone(Graph graph) {

        List<Graph.Node> nodes = new ArrayList<>();
        for(Graph.Node node : graph.nodes) {
            nodes.add(new Graph.Node(node.label));
        }

        return new Graph(nodes);
    }
}
