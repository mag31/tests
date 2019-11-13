package com.markagrant.tests;

public class AddTwoNumbersAsLists {
    public LinkedList add(LinkedList a, LinkedList b) {
        if(a.isNull())
            throw new IllegalArgumentException("a cannot be an empty list");
        if(b.isNull())
            throw new IllegalArgumentException("a cannot be an empty list");

        int sum = a.value + b.value;

        if(sum < 9) {
            return LinkedList.from(a.value + b.value);
        } else {
            return LinkedList.from(sum - 10, 1);
        }

        //return LinkedList.from(5,7,9);
    }
}
