package com.markagrant.tests;

public class ReverseLinkedList2 {

    LinkedList reverseList(LinkedList first, int m, int n) {

        if(m < 0)
            throw new IllegalArgumentException("m must be greater than zero");

        if(m > n)
            throw new IllegalArgumentException("m must be less than n");

        if(first.isTerminalNode())
            return first;

        int i = 0;
        LinkedList nodeBeforeM = LinkedList.empty;
        LinkedList nodeAtM = first;
        // get to the node before m and node m
        while(i < m) {
            nodeBeforeM = nodeAtM;
            nodeAtM = nodeAtM.next;
            i++;
        }

        LinkedList previousNode = nodeBeforeM;
        LinkedList node = nodeAtM;

        while(i < n) {
            LinkedList next = node.repointNext(previousNode);
            previousNode = node;
            node = next;
            i++;
        }

        // on the nth node we need to repoint it
        LinkedList nodeAfterN = node.repointNext(previousNode);
        if(m == 0) {
            first.repointNext(nodeAfterN);
            return node;
        }

        // then we repoint the nodeBeforeM to the Nth node
        nodeBeforeM.repointNext(node);
        // and we repoint the nodeAtM to the nodeAfterN
        nodeAtM.repointNext(nodeAfterN);

        // now ensure we are pointing to the correct first node
        return first;
    }
}
