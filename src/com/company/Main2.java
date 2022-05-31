package com.company;

import com.company.graph.MyGraph;

public class Main2 {

    // Демонстрация записи десериализации файла в граф и сериализации графа в файл
    public static void main(String[] args) {
        String pathToGraphInputFile = "res/graph.txt";
        String pathToGraphOutputFile = "res/savedGraph.txt";

        MyGraph<Integer> graph = GraphUtils.readGraphFromFile(pathToGraphInputFile);
        graph.print();
        GraphUtils.writeToFile(graph, pathToGraphOutputFile);
    }
}
