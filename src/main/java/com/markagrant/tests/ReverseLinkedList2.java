package com.markagrant.tests;

public class ReverseLinkedList2 {

    LinkedList reverseList(LinkedList first, int m, int n) {

        if(m < 0)
            throw new IllegalArgumentException("m must be greater than zero");

        if(m > n)
            throw new IllegalArgumentException("m must be less than n");

        if(first.isTerminalNode())
            return first;

        // 0 -> 1 -> 2 -> 3 -> 4 => 4 -> 3 -> 2 -> 1 -> 0
        if(m == 0) {
            int i = 0;
            // reverse every pointer and return the
            LinkedList previous = LinkedList.empty;
            LinkedList current = first;
            LinkedList next;
            while(i <= n) {
                next = current.repointNext(previous);
                previous = current;
                current = next;
                i++;
            }

            first.repointNext(current);
            return previous;
        }

        int i = 0;

        // get to the node before m
        LinkedList nodeBeforeM = LinkedList.empty;
        LinkedList nodeAtM = first;
        while(i < m) {
            nodeBeforeM = nodeAtM;
            nodeAtM = nodeAtM.next;
            i++;
        }

        LinkedList previousNode = nodeBeforeM;
        LinkedList node = nodeBeforeM.next;
        while(i < n) {
            LinkedList nextNode = node.repointNext(previousNode);
            previousNode = node;
            node = nextNode;
            i++;
        }

        // on the nth node we need to repoint it
        LinkedList nodeAfterN = node.repointNext(previousNode);
        // then we repoint the nodeBeforeM to the Nth node
        nodeBeforeM.repointNext(node);
        // and we repoint the nodeAtM to the nodeAfterN
        nodeAtM.repointNext(nodeAfterN);

        // now ensure we are pointing to the correct first node
        return first;
    }
}
