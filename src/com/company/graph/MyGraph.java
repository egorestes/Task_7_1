package com.company.graph;

import java.util.ArrayList;
import java.util.List;

public class MyGraph<T> {

    private List<MyNode<T>> nodeList = new ArrayList<>();

    public List<MyNode<T>> getNodeList() {
        return nodeList;
    }

    public void addNode(MyNode node) {
        nodeList.add(node);
    }

    public void addEdge(int idFrom, int idTo, double weight) {

        MyNode from = findById(idFrom);
        MyNode to = findById(idTo);
        MyEdge edge = new MyEdge(from, to, weight);

        from.getEdgeList().add(edge);
    }

    public MyNode findById(int id) {
        for (MyNode node :
                nodeList) {
            if (node.getId() == id)
                return node;
        }
        return null;
    }

    public void print() {
        for (MyNode node :
                nodeList) {
            System.out.println(node);
        }
    }

    public MyEdge findEdge(int indexTo, List<MyEdge> edgeList) {
        for (MyEdge edge : edgeList) {
            if ((int) edge.getTo().getValue() == indexTo) {
                return edge;
            }
        }
        return null;
    }

    public void bypassInDepth(MyNode node) {
        node.setVisited(true);

        List<MyEdge> edgeList = node.getEdgeList();

        for (MyEdge edge :
                edgeList) {
            MyNode next = edge.getTo();
            if (!next.isVisited()) {
                bypassInDepth(next);
            }
        }
    }

    public void clearAll() {
        for (MyNode<T> node :
                nodeList) {
            node.setVisited(false);
            for (int i = 0; i < node.getEdgeList().size(); i++) {
                node.getEdgeList().get(i).setVisited(false);
            }
        }
    }

    private List<MyNode> getUnreachableFromSpecifiedNodeNodes(MyNode specifiedNode) {
        clearAll();
        bypassInDepth(specifiedNode);

        List<MyNode> unreachableList = new ArrayList<>();
        for (MyNode n :
                nodeList) {
            if (!n.isVisited())
                unreachableList.add(n);
        }
        clearAll();
        return unreachableList;
    }

    public void printUnreachable(MyNode specifiedNode)  {

        if (!nodeList.contains(specifiedNode)) {
            System.out.println("Graph doesnt contain " + specifiedNode + "!");
            return;
        }

        List<MyNode> unreachableList = getUnreachableFromSpecifiedNodeNodes(specifiedNode);
        for (int i = 0; i < unreachableList.size(); i++) {
            System.out.println((i + 1) + ". " + unreachableList.get(i));
        }
    }
}
