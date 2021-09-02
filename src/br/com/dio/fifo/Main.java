package br.com.dio.fifo;

import br.com.dio.models.Node;

public class Main {
    public static void main(String[] args) {

        final Queue<String> myQueue = new Queue<>();

        System.out.println("Is empty? " + myQueue.isEmpty());

        long start = System.currentTimeMillis();
        for (int i = 1; i <= 5; i++){

            Node<String> str = new Node<>("Node nº " + i);
            System.out.println("The current value to IN is: " + str.getValue());
            myQueue.push(str);
        }

        float time = System.currentTimeMillis() - start;
        time /= 10;

        System.out.println("\n"+ myQueue.toString());
        System.out.println("The first node to be removed is: " + myQueue.first().toString());
        System.out.println("\nIs empty? " + myQueue.isEmpty());

        while (!myQueue.isEmpty()){
            System.out.println("Removing from queue: " + myQueue.dequeue());
        }

        System.out.println("\nIs empty? " + myQueue.isEmpty());
        System.out.println(myQueue.toString());
        System.out.printf("\n>>Time spent: %.3fs",time);
    }
}



