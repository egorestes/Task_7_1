package com.company.graph;

public class MyEdge<T> {

    private MyNode from;
    private MyNode to;
    private double weight;
    private boolean isVisited = false;

    public MyEdge(MyNode<T> from, MyNode<T> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public MyNode<T> getFrom() {
        return from;
    }

    public void setFrom(MyNode<T> from) {
        this.from = from;
    }

    public MyNode<T> getTo() {
        return to;
    }

    public void setTo(MyNode<T> to) {
        this.to = to;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString() {
        return "MyEdge{" +
                "from=" + from.getId() +
                ", to=" + to.getId() +
                ", weight=" + weight +
                ", isVisited=" + isVisited +
                '}';
    }
}
