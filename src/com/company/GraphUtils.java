package com.company;

import com.company.graph.MyEdge;
import com.company.graph.MyGraph;
import com.company.graph.MyNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GraphUtils {

    public static <T> MyGraph<T> readGraphFromFile(String path) {

        MyGraph<T> myGraph = new MyGraph<T>();

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            int size = 0;
            while (scanner.hasNext()) {
                scanner.nextLine();
                size++;
            }

            double[][] matrix = new double[size][size];

            scanner = new Scanner(file);

            for (int i = 0; i < size; i++) {
                String holder = scanner.nextLine();
                String[] numbers = holder.split(" ");
                for (int j = 0; j < numbers.length; j++) {
                    matrix[i][j] = Double.parseDouble(numbers[j]);
                }
            }

            for (int i = 0; i < size; i++) {
                myGraph.addNode(new MyNode(i, i));
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] != 0) {
                        myGraph.addEdge(i, j, matrix[i][j]);
                    }
                }
            }

            return myGraph;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }

    public static <T> void writeToFile(MyGraph<T> myGraph, String path) {
        File file = new File(path);
        try {
            PrintWriter printWriter = new PrintWriter(file);
            String holder = ""; // '\n'

            for (int i = 0; i < myGraph.getNodeList().size(); i++) {

                for (int j = 0; j < myGraph.getNodeList().size(); j++) {

                    MyEdge targetEdge = myGraph.findEdge(j, myGraph.getNodeList().get(i).getEdgeList());

                    if (targetEdge != null) {
                        holder += targetEdge.getWeight() + " ";
                    } else {
                        holder += "0 ";
                    }
                }

                holder += '\n';
            }
            printWriter.write(holder);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
