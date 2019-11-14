package com.markagrant.tests;

import java.util.ArrayList;
import java.util.List;

class Graph {

    String label;

    List<Graph> neighbours;

    Graph(String label) {
        if(label == null)
            throw new NullPointerException("label cannot be null");

        this.label = label;
        neighbours = new ArrayList<>();
    }

    private void addNeighbour(Graph neighbour) {
        neighbours.add(neighbour);
    }

    static void link(Graph n1, Graph n2) {
        n1.addNeighbour(n2);
        n2.addNeighbour(n1);
    }
}
