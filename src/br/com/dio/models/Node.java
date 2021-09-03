package br.com.dio.models;

public class Node<T> {

    private T value;
    private Node<T> refNode;

    public Node() {
        value = null;
        refNode = null;
    }

    public Node(T value){
        this.value = value;
        refNode = null;
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
        String type = value.getClass().getSimpleName();

        if (type instanceof String){
            return "\""+value+"\"";
        }

        return value.toString();
    }
}
