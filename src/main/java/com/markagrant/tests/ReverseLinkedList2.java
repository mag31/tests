package com.markagrant.tests;

public class ReverseLinkedList2 {

    static class Node {

        int value;
        Node next;

        Node(int value, Node next) {
           this.value = value;
           this.next = next;
        }

        Node repointNext(Node node) {
            Node oldNext = next;
            next = node;
            return oldNext;
        }

        boolean isTerminalNode() {
            return next == null;
        }
    }

    static Node empty = new Node(-1, null);

    static Node list(int ... values) {
        Node node = empty;
        for(int i = values.length - 1; i >= 0; i--) {
            node = new Node(values[i], node);
        }

        return node;
    }

    Node reverseList(Node first, int m, int n) {

        if(m < 0)
            throw new IllegalArgumentException("m must be greater than zero");

        if(m > n)
            throw new IllegalArgumentException("m must be less than n");

        if(first.isTerminalNode())
            return first;

        Node previousNode = empty;
        Node node = first;
        while(!node.next.isTerminalNode()) {

            Node nextNode = node.repointNext(previousNode);
            previousNode = node;
            node = nextNode;
        }

        node.repointNext(previousNode);

        return node;
    }
}
