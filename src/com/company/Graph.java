package com.company;

public class Graph {




    public void addEdge(Vertex vertexA, Vertex vertexB){
        vertexA.add_edge(vertexB);
        vertexB.add_edge(vertexA);
    }

}
