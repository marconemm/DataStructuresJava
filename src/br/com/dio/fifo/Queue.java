package br.com.dio.fifo;

import br.com.dio.models.Node;

public class Queue<T> {
    private Node<T> lastNode;
    private int length;

    public Queue() {
        lastNode = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty(){
        return lastNode == null;
    }

    @Override
    public String toString() {
        String result;

        if (lastNode == null) {
            result = "Queue{" +
                    "lastNode=null" +
                    ", length=" + length +
                    '}';
        }else{
            result = "Queue{" +
                    "lastNode=" + lastNode.toString() +
                    ", length=" + length +
                    '}';
        }

        return result;
    }

    public void push(Node<T> nextNode){
        if (!isEmpty()) {
            nextNode.setRefNode(lastNode);
        }
        lastNode = nextNode;
        length++;
    }

    public Node<T> first(){

        if (isEmpty()){
            return lastNode;
        }

        Node<T> firstNode = lastNode;
        while (firstNode.getRefNode() != null){
            firstNode = firstNode.getRefNode();
        }
        return firstNode;
    }

    public T dequeue(){
        Node<T> auxNode = lastNode;
        length--;
        if (auxNode.getRefNode() == null){
            lastNode = null;
            return auxNode.getValue();
        }
        while (auxNode.getRefNode().getRefNode() != null){
            auxNode = auxNode.getRefNode();
        }
        T value = auxNode.getRefNode().getValue();
        auxNode.setRefNode(null);
        return  value;
    }


}
