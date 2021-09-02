package br.com.dio.lifo;

import br.com.dio.models.Node;

public class Main {
    public static void main(String[] args) {

        final Stack<String> myStack = new Stack<>();

        System.out.println("Is empty? " + myStack.isEmpty());

        for (int i = 1; i < 5; i++){
            Node<String> str = new Node<>("Node nº " + i);
            System.out.println("The current node to IN is: " + str.getValue());
            myStack.push(str);
        }

        System.out.println("Is empty? " + myStack.isEmpty());
        System.out.println("Stack size: " + myStack.size());

        System.out.println("The last node in this stack is: " + myStack.top().toString());

        while (!myStack.isEmpty()){
            System.out.println("The first node to OUT was: " + myStack.pop().toString());
        }
    }
}



