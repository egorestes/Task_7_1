package com.company.graph;

import java.util.ArrayList;
import java.util.List;

public class MyNode<T> {

    private T value;
    private int id;
    private boolean isVisited = false;
    private List<MyEdge> edgeList = new ArrayList<>();

    public MyNode(T value, int id) {
        this.value = value;
        this.id = id;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<MyEdge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<MyEdge> edgeList) {
        this.edgeList = edgeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodesId() {
        String holder = "";
        for (MyEdge edge :
                edgeList) {
            holder += edge.getTo().getId() + ", ";
        }
        return holder;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "id = " + id +
                ", value = " + value +
                ", isVisited = " + isVisited +
                ", edgeList = " + getNodesId() +
                '}';
    }
}
