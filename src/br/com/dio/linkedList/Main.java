package br.com.dio.linkedList;

import br.com.dio.models.Node;

public class Main {
    public static void main(String[] args) {

        final LinkedList<Integer> myLinkedList = new LinkedList<>();

        System.out.println("Is empty? " + myLinkedList.isEmpty());

        for (int i = 1; i < 5; i++){
            Node<Integer> currNode = new Node<>(i);
            System.out.println("The current node to IN is: " + currNode.getValue());
            myLinkedList.add(currNode);
        }

        System.out.println("\nIs empty? " + myLinkedList.isEmpty());
        System.out.println("Stack size: " + myLinkedList.size());
        System.out.println("My linked list: " + myLinkedList.toString());

        final  int index = 2;
        System.out.println("\nThe value at index " + index + " is: " + myLinkedList.get(index));
        myLinkedList.remove(index);
        System.out.println("\nRemoving he value at index " + index + "...");
        System.out.println("My linked list: " + myLinkedList.toString());
    }
}
