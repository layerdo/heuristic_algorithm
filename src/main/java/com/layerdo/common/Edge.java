package com.layerdo.common;

public class Edge {
    private Node from;
    private Node to;
    private double distance;

    public Edge() {

    }

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
        this.distance = getEuclideanDistance(from, to);
    }

    public Edge reverseEdge() {
        Edge reverseEdge = new Edge();
        reverseEdge.from = this.to;
        reverseEdge.to = this.from;
        reverseEdge.distance = this.distance;
        return reverseEdge;
    }

    private double getEuclideanDistance(Node from, Node to) {
        return Math.sqrt(Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2));
    }
}
