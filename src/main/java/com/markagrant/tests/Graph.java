package com.markagrant.tests;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Graph {

    class Node {
        String label;

        List<String> neighbours;

        Node(String label, String ... neighbours) {
            this.label = label;
            this.neighbours = Arrays.stream(neighbours).sorted().collect(Collectors.toList());
        }

        boolean checkClone(Node original) {
            return label.equals(original.label) &&
                    neighbours.size() == original.neighbours.size() &&
                    neighbours.containsAll(original.neighbours);
        }
    }

    List<Node> nodes;

    Graph(Node ... nodes) {
        this.nodes = Arrays.stream(nodes)
                .sorted(Comparator.comparing(n -> n.label))
                .collect(Collectors.toList());
    }

    boolean checkClone(Graph original) {
        if(nodes.size() != original.nodes.size())
            return false;

        for(int i = 0; i < nodes.size(); i++) {
            if(!nodes.get(i).checkClone(original.nodes.get(i)))
                return false;
        }

        return true;
    }
}
