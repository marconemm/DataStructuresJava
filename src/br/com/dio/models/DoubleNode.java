package br.com.dio.models;

public class DoubleNode<T> {

    private T value;
    private DoubleNode<T> nextNode;
    private DoubleNode<T> prevNode;

    public DoubleNode() {
        value = null;
        nextNode = null;
        prevNode = null;
    }

    public DoubleNode(T value){
        this.value = value;
        nextNode = null;
        prevNode = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleNode<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(DoubleNode<T> prevNode) {
        this.prevNode = prevNode;
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
