package com.company;

import com.company.graph.MyGraph;
import com.company.graph.MyNode;

public class Main {
    //1. Найти все вершины графа, недостижимые из заданной вершины.

    public static void main(String[] args) {
        MyGraph<Integer> graph = new MyGraph<>();

        MyNode<Integer> node0 = new MyNode(0, 0);
        MyNode<Integer> node1 = new MyNode(1, 1);
        MyNode<Integer> node2 = new MyNode(2, 2);
        MyNode<Integer> node3 = new MyNode(3, 3);
        MyNode<Integer> node4 = new MyNode(4, 4);
        MyNode<Integer> node5 = new MyNode(5, 5);

        graph.addNode(node0);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);

        graph.addEdge(0, 1, 10);
        graph.addEdge(1, 2, 11);
        graph.addEdge(2, 3, 12);
        graph.addEdge(3, 4, 13);
        graph.addEdge(4, 0, 14);

        graph.addEdge(2, 0, 15);

        graph.addEdge(3, 1, 16);

        graph.addEdge(4, 4, 17);
        graph.addEdge(4, 2, 18);

        graph.print();

        System.out.println();
        System.out.println("Unreachable from node0:");
        graph.printUnreachable(node0);

        System.out.println();
        System.out.println("Unreachable from node4:");
        graph.printUnreachable(node4);

        System.out.println();
        System.out.println("Unreachable from node5:");
        graph.printUnreachable(node5);
    }
}
