package com.markagrant.tests;

import org.junit.Test;

import static com.markagrant.tests.Tree.node;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidBinarySearchTreeTest {

    @Test
    public void can_validate_tree() {
        ValidBinarySearchTree valid = new ValidBinarySearchTree();

        assertTrue(valid.isValid(new Tree(null, 0, null)));
    }

    @Test
    public void can_validate_tree2() {
        ValidBinarySearchTree valid = new ValidBinarySearchTree();

        assertTrue(valid.isValid(node(node(1), 2, node(3))));
    }

    @Test
    public void is_invalid_tree() {
        ValidBinarySearchTree valid = new ValidBinarySearchTree();

        assertFalse(valid.isValid(node(node(3), 2, node(1))));
    }

    @Test
    public void has_overlap() {
        ValidBinarySearchTree valid = new ValidBinarySearchTree();

        assertFalse(valid.isValid(node(node(node(1),3, node(5)), 4, node(6))));
    }
}