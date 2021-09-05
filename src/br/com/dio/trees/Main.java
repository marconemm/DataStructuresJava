package br.com.dio.trees;

import br.com.dio.models.LeafNode;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer> myTree = new MyBinaryTree<>();

        LeafNode<Integer> toRemove = new LeafNode<>(31);

        myTree.insert(new LeafNode<>(13));
        myTree.insert(new LeafNode<>(10));
        myTree.insert(new LeafNode<>(25));
        myTree.insert(new LeafNode<>(2));
        myTree.insert(new LeafNode<>(12));
        myTree.insert(new LeafNode<>(20));
        myTree.insert(toRemove);
        myTree.insert(new LeafNode<>(29));

        myTree.show(MyBinaryTree.orders.PRE_ORDER);
        myTree.show(MyBinaryTree.orders.IN_ORDER);
        myTree.show(MyBinaryTree.orders.AFT_ORDER);

        System.out.println("\nRemoving the element: " + toRemove + "...");
        myTree.remove(toRemove);

        myTree.show(MyBinaryTree.orders.PRE_ORDER);
        myTree.show(MyBinaryTree.orders.IN_ORDER);
        myTree.show(MyBinaryTree.orders.AFT_ORDER);

        /*
        MyBinaryTree<Integer> myTree2 = new MyBinaryTree<>();

        LeafNode<Integer> toRemove2 = new LeafNode<>(311);

        myTree2.insert(new LeafNode<>(1));
        myTree2.insert(new LeafNode<>(10));
        myTree2.insert(toRemove2);
        myTree2.insert(new LeafNode<>(100));
        myTree2.insert(new LeafNode<>(0));


        myTree.show(MyBinaryTree.orders.PRE_ORDER);
        myTree.show(MyBinaryTree.orders.IN_ORDER);
        myTree.show(MyBinaryTree.orders.AFT_ORDER);

        myTree.remove(toRemove);

        myTree.show(MyBinaryTree.orders.PRE_ORDER);
        myTree.show(MyBinaryTree.orders.IN_ORDER);
        myTree.show(MyBinaryTree.orders.AFT_ORDER);
        */
    }
}
