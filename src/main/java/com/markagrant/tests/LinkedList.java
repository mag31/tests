package com.markagrant.tests;

class LinkedList {

    int value;
    LinkedList next;

    LinkedList(int value, LinkedList next) {
       this.value = value;
       this.next = next;
    }

    LinkedList repointNext(LinkedList node) {
        LinkedList oldNext = next;
        next = node;
        return oldNext;
    }

    boolean isTerminalNode() {
        return next == null;
    }

    public String toString() {
        return value == -1 ? " NULL" : "" + value;
    }

    static LinkedList empty = new LinkedList(-1, null);

    static LinkedList from(int ... values) {
        LinkedList node = empty;
        for(int i = values.length - 1; i >= 0; i--) {
            node = new LinkedList(values[i], node);
        }

        return node;
    }
}
