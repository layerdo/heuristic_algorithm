package com.layerdo.common;

import java.util.*;

public class Graph {
    Map<Node, Map<Node, Edge>> graph = new HashMap<>();

    public Graph() {

    }

    private Set<Node> getAllNodes() {
        return graph.keySet();
    }

    private Map<Node, Edge> getNodeEdges(Node node) {
        return graph.get(node);
    }

    public boolean addNode(Node node) {
        if (getAllNodes().contains(node)) {
            return false;
        }
        graph.put(node, new HashMap<>());
        return true;
    }

    public boolean removeNode(Node node) {
        if (!getAllNodes().contains(node)) {
            return false;
        }
        Map<Node, Edge> toEdges = getNodeEdges(node);
        for (Node to : toEdges.keySet()) {
            removeEdge(node, to);
            removeEdge(to, node);
        }
        graph.remove(node);
        return true;
    }

    public boolean addEdge(Node from, Node to) {
        if (graph.get(from) == null || graph.get(to) == null) {
            return false;
        }
        Edge edge = new Edge(from, to);
        graph.get(from).put(to, edge);
        graph.get(to).put(from, edge.reverseEdge());
        return true;
    }

    public boolean removeEdge(Node from, Node to) {
        Map<Node, Edge> fromEdges = getNodeEdges(from);
        Map<Node, Edge> toEdges = getNodeEdges(to);
        if (fromEdges == null || fromEdges.size() == 0 || toEdges == null || toEdges.size() == 0) {
            return false;
        }
        // 下面两行手动清理边，方便回收。可以不要。
        Edge edge = graph.get(from).get(to);
        edge = null;
        graph.get(from).remove(to);
        return true;
    }
}
