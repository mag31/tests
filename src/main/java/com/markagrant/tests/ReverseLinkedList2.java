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
        if(first.isTerminalNode())
            return first;

        Node second = first.repointNext(empty);
        Node third = second.repointNext(first);
        Node forth = third.repointNext(second);
        Node fifth = forth.repointNext(third);
        fifth.repointNext(forth);

        return fifth;
    }
}
