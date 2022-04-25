package ru.vsu.cs.tarantsov;

public class BinaryTree {

    private Node root;

    protected class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this(value, null, null);
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
        public void setLeft(Node node) {
            this.left = node;
        }
        public void setRight(Node node) {
            this.right = node;
        }
    }

    public Node getRootNode() {
        return root;
    }

    public void insertNode(String word) {
        int value = word.hashCode();
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }
        Node curr = root;
        while (true) {
            if (curr.getValue() == value)
                return;
            else if (curr.getValue() > value) {
                Node parentNode = curr;
                curr = curr.getLeft();
                if (curr == null) {
                    parentNode.setLeft(newNode);
                    return;
                }
            } else if (curr.getValue() < value) {
                Node parentNode = curr;
                curr = curr.getRight();
                if (curr == null) {
                    parentNode.setRight(newNode);
                    return;
                }
            }

        }
    }

        public boolean findByValue(String word) {
            int value = word.hashCode();
            Node newNode = new Node(value);

            if (root == null) {
                return false;
            }
            Node curr = root;
            while (true) {
                if (curr.getValue() == value)
                    return true;
                else if (curr.getValue() > value) {
                    curr = curr.getLeft();
                    if (curr == null) {

                        return false;
                    }
                } else if (curr.getValue() < value) {

                    curr = curr.getRight();
                    if (curr == null) {

                        return false;
                    }
                }

            }
        }

    }
