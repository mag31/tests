package com.markagrant.tests;

class Tree  implements Comparable<Tree> {

    int value;

    Tree left;

    Tree right;

    Tree(Tree left, int value, Tree right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    static Tree node(int value) {
        return new Tree(null, value, null);
    }

    static Tree node(Tree left, int value) {
        return new Tree(left, value, null);
    }

    static Tree node(int value, Tree node) {
        return new Tree(null, value, node);
    }

    static Tree node(Tree left, int value, Tree right) {
        return new Tree(left, value, right);
    }

    @Override
    public int compareTo(Tree other) {
        return value - other.value;
    }
}
