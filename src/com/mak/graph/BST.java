package com.mak.graph;

import java.util.List;

public class BST {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }


    public static Node insert(Node root, int value){
        if(root == null){
            return new Node(value);
        }
        if(value > root.value)
            root.right = insert(root.right, value);
        else
            root.left = insert(root.left, value);

        return root;
    }

    public static void print(Node root){
        if (root == null)
            return;

        print(root.left);
        System.out.print(root.value + " ");
        print(root.right);
    }

    public static boolean search(Node root, int value){
        if (root == null)
            return false;

        if(root.value > value){
            return search(root.left, value);
        }else if(root.value < value){
            return search(root.right, value);
        } else return true;

    }

    public static Node delete(Node root, int value){
        if (root == null)
            return null;

        if(value < root.value){
            root.left = delete(root.left, value);
        }
        else if(value > root.value){
            root.right = delete(root.right, value);
        }
        else {
            if (root.left != null && root.right != null){
                //find in order successor
                Node is = getInorderSuccessor(root.right);
                root.value =  is.value;
                root.right = delete(root.right, is.value);
            }
            else if (root.right != null){
                return root.right;
            }
            else if (root.left != null){
                return root.left;
            }
            else return null;

        }

        return root;
    }

    private static Node getInorderSuccessor(Node root){
        while (root != null && root.left != null){
            root = root.left;
        }
        return root;
    }

    public static boolean validBST(Node root, int lowerBound, int upperBound){
        if (root == null)
            return true;

        if(lowerBound <= root.value && root.value <= upperBound){
            return validBST(root.left, lowerBound, root.value) &&
                    validBST(root.right, root.value, upperBound);
        }
        return false;

    }

    public static void main(String[] args) {
        List<Integer> data = List.of(3, 2, 5, 1, 4, 6);
        Node root = null;
        for (int value : data){
            root = insert(root, value);
        }
        print(root);
        System.out.println();
        System.out.println("Found: " + search(root, 10));

        print(delete(root, 6));
        System.out.println();
        print(delete(root, 2));
        System.out.println();
        print(delete(root, 5));
        System.out.println();
        print(delete(root, 3));
        System.out.println();

        var root1 = new Node(4);
        root1.left = new Node(2);
        root1.right = new Node(5);

        root1.right.left = new Node(3);
        root1.right.right = new Node(6);

        System.out.println("Valid BST: " + validBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));

        Node root2 = null;
        for (int value : data){
            root2 = insert(root, value);
        }
        System.out.println("Valid BST: " + validBST(root2, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

}
