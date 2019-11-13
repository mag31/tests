package com.markagrant.tests;

public class ReverseLinkedList2 {

    int i = 0;

    LinkedList reverseList(LinkedList first, int m, int n) {

        if(m < 0)
            throw new IllegalArgumentException("m must be greater than zero");

        if(m > n)
            throw new IllegalArgumentException("m must be less than n");

        if(first.isTerminalNode())
            return first;

        LinkedList nodeBeforeM = LinkedList.empty;
        LinkedList nodeAtM = first;
        // iterate through to m
        while(i < m) {
            nodeBeforeM = nodeAtM;
            nodeAtM = nodeAtM.next;
            i++;
        }

        LinkedList previousNode = nodeBeforeM;
        LinkedList node = nodeAtM;

        // reverse pointers up to n
        while(i < n) {
            LinkedList next = node.repointNext(previousNode);
            previousNode = node;
            node = next;
            i++;
        }

        // reverse the nth node
        LinkedList nodeAfterN = node.repointNext(previousNode);

        // reattach the node at m by pointing to to the node after n
        nodeAtM.repointNext(nodeAfterN);
        if(m == 0) {
            // when we are reversing the first node in the list then the start of the list is just the nth node
            return node;
        } else {
            // if the first node isn't reversed then we need to reattach the node before m to the nth node
            nodeBeforeM.repointNext(node);

            // and the list still starts at the first node
            return first;
        }
    }
}
