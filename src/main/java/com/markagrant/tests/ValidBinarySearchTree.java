package com.markagrant.tests;

public class ValidBinarySearchTree {
    public boolean isValid(Tree tree) {
        return isValid(Integer.MIN_VALUE, tree, Integer.MAX_VALUE);
    }

    private boolean isValid(int lowerBound, Tree tree, int upperBound) {
        return
            (tree.left == null || (tree.compareTo(tree.left) > 0 && isValid(lowerBound, tree.left, tree.value))) &&
            (tree.right == null || (tree.compareTo(tree.right) < 0 && isValid(tree.value, tree.right, upperBound))) &&
                tree.value > lowerBound && tree.value < upperBound;
    }
}
