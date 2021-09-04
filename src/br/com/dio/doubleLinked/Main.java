package br.com.dio.doubleLinked;

import br.com.dio.models.DoubleNode;
import br.com.dio.utils.Random;

public class Main {
    public static void main(String[] args) {

        final DoubleLinkedList<Integer>  myDoubleLinkedList = new DoubleLinkedList<>();


        System.out.println("Is empty? " + myDoubleLinkedList.isEmpty());
        
        for (int i = 0; i < 5; i++) {
        	final int number = Random.getRandomValueBetween(1, 40);
        	
        	System.out.println("\nAdding value: " + number + " to the list;");        	
        	myDoubleLinkedList.add(new DoubleNode<Integer>(number));
            System.out.println("My double linked list size: " + myDoubleLinkedList.size());       
		}
        
        for (int i = 0; i < 5; i++) {
        	final int number = Random.getRandomValueBetween(1, 40);
        	
        	System.out.println("\nInsert value: " + number + " at index " + i + ";");
        	
        	myDoubleLinkedList.add(new DoubleNode<Integer>(number), i);
            System.out.println("My double linked list size: " + myDoubleLinkedList.size());       
		}
        
        System.out.println("\nIs empty? " + myDoubleLinkedList.isEmpty());
        System.out.println("My double linked list: " + myDoubleLinkedList.toString());
        System.out.println("My double linked list size: " + myDoubleLinkedList.size());        
        
        int index = 4;
        System.out.println("\n...\n\nThe value on index " + index + " is: " + myDoubleLinkedList.get(index));
        index = -2;
        System.out.println("The value on index " + index + " is: " + myDoubleLinkedList.get(index));
        
        
        for (int i = 0; i <= 5; i++) {
        	final int number = Random.getRandomValueBetween(50, 100);
        	index = Random.getRandomValueBetween(-myDoubleLinkedList.size(), myDoubleLinkedList.size());
        	
        	System.out.println("\nInserting the number " + number + " at index " + index + "...");
        	myDoubleLinkedList.add(new DoubleNode<Integer>(number), index);
        	System.out.println("My double linked list: " + myDoubleLinkedList.toString());
		}
        
        System.out.println("\n...\n");
        
        int limit = myDoubleLinkedList.size() / 3;
        
        for (int i = 0; i <= limit; i++) {
        	index = Random.getRandomValueBetween(-myDoubleLinkedList.size(), myDoubleLinkedList.size());
        	
        	final int value = myDoubleLinkedList.remove(index);
        	System.out.println("\nThe value \"" + value + " was romoved form index " + index + ".");
        	System.out.println("My double linked list: " + myDoubleLinkedList.toString());
		}
    }
}
