package com.markagrant.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Graph {

    static class Node {
        String label;

        List<Node> neighbours;

        Node(String label) {
            this.label = label;
            neighbours = new ArrayList<>();
        }

        void addNeighbour(Node neighbour) {
            neighbours.add(neighbour);
        }

        boolean checkClone(Node original) {
            return label.equals(original.label) &&
                    neighbours.size() == original.neighbours.size() &&
                    neighbours.containsAll(original.neighbours);
        }

        static void link(Node n1, Node n2) {
            n1.addNeighbour(n2);
            n2.addNeighbour(n1);
        }

    }

    List<Node> nodes;

    Graph(List<Node> nodes) {
        this.nodes = nodes.stream()
                .sorted(Comparator.comparing(n -> n.label))
                .collect(Collectors.toList());
    }

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
