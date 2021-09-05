package br.com.dio.trees;

import br.com.dio.models.LeafNode;

public class MyBinaryTree<T extends Comparable<T>> {
    public enum orders {PRE_ORDER, IN_ORDER, AFT_ORDER}

    private final StringBuilder strResult = new StringBuilder("[");
    private LeafNode<T> root;

    public MyBinaryTree() {
        root = null;
    }

    private LeafNode<T> insert(LeafNode<T> current, LeafNode<T> newLeaf) {
        if (current == null) {
            return newLeaf;
        }

        if (newLeaf.getValue().compareTo(current.getValue()) < 0) {

            current.setLeftNode(insert(current.getLeftNode(), newLeaf));

        } else {

            current.setRightNode(insert(current.getRightNode(), newLeaf));

        }

        return current;
    }

    private void ShowPreOrder(LeafNode<T> current) {
        if (current != null) {
            //Show the elements in a diagonal from right to left:
            strResult.append(current.getValue()).append(", ");
            ShowPreOrder(current.getLeftNode());
            ShowPreOrder(current.getRightNode());
        }
    }

    private void ShowInOrder(LeafNode<T> current) {

        if (current != null) {
            //Sink to the left, show the deepest found node, then emerge back showing the nodes found at right:
            ShowInOrder(current.getLeftNode());
            strResult.append(current.getValue()).append(", ");
            ShowInOrder(current.getRightNode());
        }

    }

    private void ShowAfterOrder(LeafNode<T> current) {

        if (current != null) {
            /*Find the deepest node at left and show it;
              After shows the same level right node and shows it;
              If the right node doesn't exist, shows the left parent node; and
              Repeat the same in the previous node.
             */

            ShowAfterOrder(current.getLeftNode());
            ShowAfterOrder(current.getRightNode());
            strResult.append(current.getValue()).append(", ");
        }

    }

    public void show(orders order) {
        strResult.setLength(1); //reset the result string.

        switch (order) {
            case PRE_ORDER -> {
                System.out.println("\nShowing the leaves after in \"Pre Order\":");
                ShowPreOrder(root);
                strResult.setCharAt(strResult.length() - 2,']');
                System.out.println(strResult.substring(0, strResult.length() - 1));
            }
            case IN_ORDER -> {
                System.out.println("\nShowing the leaves after in \"In Order\":");
                ShowInOrder(root);
                strResult.setCharAt(strResult.length() - 2,']');
                System.out.println(strResult.substring(0, strResult.length() - 1));
            }
            default -> {
                System.out.println("\nShowing the leaves after in \"After Order\":");
                ShowAfterOrder(root);
                strResult.setCharAt(strResult.length() - 2,']');
                System.out.println(strResult.substring(0, strResult.length() - 1));
            }
        }
    }

    public void insert(LeafNode<T> newLeaf) {
        root = insert(root, newLeaf);
    }

    public void remove(LeafNode<T> toRemove) {
        if (toRemove != null) {
            LeafNode<T> currentNode = root;
            LeafNode<T> superNode = null, childNode, tempNode;

            while (!currentNode.getValue().equals(toRemove.getValue())) {
                superNode = currentNode;

                if (toRemove.getValue().compareTo(currentNode.getValue()) < 0) {
                    currentNode = currentNode.getLeftNode();
                } else {
                    currentNode = currentNode.getRightNode();
                }

                if (currentNode == null) {
                    System.out.println("Leaf (" + toRemove + "), not found.");
                    break;
                }
            }

            if (superNode == null) {
                root = currentNode.getRightNode() == null ? currentNode.getLeftNode() :
                        currentNode.getLeftNode() == null ? currentNode.getRightNode() : root;

                for (tempNode = currentNode,
                             childNode = currentNode.getLeftNode();
                     childNode.getRightNode() != null;
                     tempNode = childNode,
                             childNode = childNode.getLeftNode()) {

                    if (childNode != currentNode.getLeftNode()) {
                        tempNode.setRightNode(childNode.getLeftNode());
                        childNode.setLeftNode(root.getLeftNode());
                    }

                    childNode.setRightNode(root.getRightNode());
                    root = childNode;
                }

            } else if (currentNode != null && currentNode.getRightNode() == null) {

                if (superNode.getLeftNode() == currentNode) {
                    superNode.setLeftNode(currentNode.getLeftNode());
                } else {
                    superNode.setRightNode(currentNode.getLeftNode());
                }
            } else if (currentNode != null && currentNode.getLeftNode() == null) {

                if (superNode.getLeftNode() == currentNode) {
                    superNode.setLeftNode(currentNode.getRightNode());
                } else {
                    superNode.setRightNode(currentNode.getRightNode());
                }
            } else {
                for (tempNode = currentNode,
                             childNode = currentNode.getLeftNode();
                     childNode.getRightNode() != null;
                     tempNode = childNode,
                             childNode = childNode.getRightNode()) {

                    if (childNode != currentNode.getLeftNode()) {
                        tempNode.setRightNode(childNode.getLeftNode());
                        childNode.setLeftNode(currentNode.getLeftNode());
                    }

                    childNode.setRightNode(currentNode.getRightNode());

                    if (superNode.getLeftNode() == currentNode) {
                        superNode.setLeftNode(childNode);
                    } else {
                        superNode.setRightNode(childNode);
                    }
                }
            }
        }
    }
}
