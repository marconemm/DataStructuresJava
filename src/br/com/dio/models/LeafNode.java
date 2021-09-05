package br.com.dio.models;

public class LeafNode<T extends Comparable<T>> {

    private final T value;
    private LeafNode<T> leftNode;
    private LeafNode<T> rightNode;

    public LeafNode(T value) {
        this.value = value;
        leftNode = rightNode = null;
    }

    public T getValue() {
        return value;
    }

    public LeafNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(LeafNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public LeafNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(LeafNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
