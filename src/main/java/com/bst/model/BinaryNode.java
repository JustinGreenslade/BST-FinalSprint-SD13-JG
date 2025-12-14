package com.bst.model;

public class BinaryNode {

    public Integer value;
    public BinaryNode left; // left will always be less the value
    public BinaryNode right; // right will be greater

    public BinaryNode() {
        this.left = null;
        this.right = null;
    }

    public BinaryNode(Integer value) {

        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" + value + "}";
    }
}