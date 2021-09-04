package br.com.dio.linkedList;

import br.com.dio.models.Node;

public class LinkedList<T> {
    private int length;
    private Node<T> refNode;

    public LinkedList() {
        length = 0;
        refNode = null;
    }

    private Node<T> getNode(int index){
        final int maxIndex = length - 1;

        if (index < 0){
            throw new IndexOutOfBoundsException("The min index to this list is: 0");
        }

        if (index > maxIndex){
            throw new IndexOutOfBoundsException("The max index to this list is: " + maxIndex);
        }

        Node<T> result = refNode;
        for (int i = maxIndex; i > index; i--){
            result = result.getRefNode();
        }

        return  result;
    }

    public boolean isEmpty(){
        return refNode == null;
    }

    public int size(){
        return  length;
    }

    public void add(Node<T> nextNode){
        if (!isEmpty()){
            nextNode.setRefNode(refNode);
        }

        refNode = nextNode;
        length++;
    }

    public T get(int index){
        return getNode(index).getValue();
    }

    public void remove(int index){
        Node<T> currNode = refNode;
        Node<T> toRemove = getNode(index);

        for (int i = (length - 1); i > (index + 1) ; i--) {
                currNode = currNode.getRefNode();
        }

        currNode.setRefNode(toRemove.getRefNode());
        toRemove = null;
        length--;
    }

    @Override
    public String toString() {
        Node<T> auxNode = refNode;

        if (auxNode == null){
            return "[]";
        }

        String result = "[";
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                auxNode = auxNode.getRefNode();
            }
            result += auxNode.getValue() + ", ";
            auxNode = refNode; // reset the "pointer";
        }
        result = result.substring(0, result.length() - 2);
        result += "]";

        return result;
    }
}
