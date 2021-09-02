package br.com.dio.models;

public class Node<T> {

    private T value = null;
    private Node<T> refNode = null;

    public Node() {}

    public Node(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getRefNode() {
        return refNode;
    }

    public void setRefNode(Node<T> refNode) {
        this.refNode = refNode;
    }

    @Override
    public String toString() {
        String type = value.getClass().getName();

        return "Node{" +
                "value=" + value +
                ", type=" + type.substring(10, type.length()) +
                '}';
    }
}
