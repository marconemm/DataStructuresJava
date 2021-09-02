package br.com.dio.lifo;

import br.com.dio.models.Node;

public class Stack<T> {

    private int length;
    private Node<T> currentNode;

    public Stack() {
        length = 0;
        currentNode = null;
    }

    public Node<T> getCurrentNode() {
        return currentNode;
    }

    public boolean isEmpty() {
        return currentNode == null;
    }

    public int size() {
        return length;
    }

    public void push(Node<T> nextNode) {
        nextNode.setRefNode(currentNode);
        currentNode = nextNode;
        length += 1;
    }

    public Node<T> top() {
        return currentNode;
    }

    public Node<T> pop(){
        Node<T> poppedNode = currentNode;
        currentNode = currentNode.getRefNode();
        length -= 1;

        return poppedNode;
    }
}