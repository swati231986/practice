package graphs;


import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public  int numVertices;
    public List<Multiset<Integer>> adjacentVertices;

    public Graph(int vertices) {
        this.numVertices = vertices;
        adjacentVertices = new ArrayList<>();
        ((ArrayList<Multiset<Integer>>) adjacentVertices).ensureCapacity(numVertices);
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacentVertices.get(vertex1).add(vertex2);
        adjacentVertices.get(vertex2).add(vertex1);
    }

    public void addVertex(int vertex) {
        Multiset<Integer> newVertices = HashMultiset.create();
        adjacentVertices.add(vertex, newVertices);
    }

    public Multiset<Integer> getAdjacentVertices(int vertex) {
        return adjacentVertices.get(vertex);
    }

}
