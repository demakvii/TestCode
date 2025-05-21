package com.mak.model;

public class GraphTwoNode {

    private Integer value;
    private GraphTwoNode left;
    private GraphTwoNode right;

    public GraphTwoNode(Integer value, GraphTwoNode left, GraphTwoNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public GraphTwoNode getLeft() {
        return left;
    }

    public void setLeft(GraphTwoNode left) {
        this.left = left;
    }

    public GraphTwoNode getRight() {
        return right;
    }

    public void setRight(GraphTwoNode right) {
        this.right = right;
    }
}
