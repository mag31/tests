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
        if(a.isNull() && b.isNull())
            return carry ?
                new LinkedList(1, LinkedList.empty) :
                LinkedList.empty;

        LinkedList safeA = a.isNull() ? new LinkedList(0, LinkedList.empty) : a;
        LinkedList safeB = b.isNull() ? new LinkedList(0, LinkedList.empty) : b;

        int sum = safeA.value + safeB.value + (carry ? 1 : 0);

        boolean carryNext = sum > 9;

        LinkedList nextResult = add(safeA.next, safeB.next, carryNext);

        return new LinkedList(carryNext ? sum - 10 : sum, nextResult);
    }
}
