package com.markagrant.tests;

public class AddTwoNumbersAsLists {
    public LinkedList add(LinkedList a, LinkedList b) {
        if(a.isNull())
            throw new IllegalArgumentException("a cannot be an empty list");
        if(b.isNull())
            throw new IllegalArgumentException("a cannot be an empty list");

        return add(a, b, false);
    }

    private LinkedList add(LinkedList a, LinkedList b, boolean carry) {
        if(a.isNull() && b.isNull() && carry)
            return new LinkedList(1, LinkedList.empty);

        if(a.isNull())
            return a;

        int sum = a.value + b.value + (carry ? 1 : 0);

        boolean carryNext = sum > 9;

        LinkedList nextResult = add(a.next, b.next, carryNext);

        return new LinkedList(carryNext ? sum - 10 : sum, nextResult);
    }
}
