package com.company;

import java.util.*;

/**
 * This class contains my implementation of DFS and BFS.
 *
 * For DFS, the graph is fully explored by an iteration node until no adjacent nodes are found. If this is the case, the iterator backtracks until it reaches the node which
 * contains an explored adjacent node. If no adjacent nodes are found, then the iteration is done.
 *
 * For BFS, the adjacent nodes of the source are found and then the adjacent nodes of those adjacent nodes are found.
 *
 * DFS uses a stack since backtracking is used while BFS uses a queue where the first item out is one of the adjacent nodes are adjacent to the source
 *
 * The time complexities for both are O(V+E) where V = vertices and E = edges. This is due to the fact that the iterator must iterate through all nodes as well as grab
 * adjacent nodes (edges)
 */


public class Main {

    public static void main(String[] args) {

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");

       Graph graph = new Graph();
       graph.addEdge(A,B);
       graph.addEdge(A,D);
       graph.addEdge(A,C);
       graph.addEdge(B,E);
       graph.addEdge(B,D);
       graph.addEdge(D,G);
       graph.addEdge(E,G);

       print_BFS(E);

    }

    public static void print_DFS(Vertex vertex){
        Vertex[] vertices = DFS(vertex);


        String string = "";

        for (Vertex v : vertices){
            if (v != null) {
                string += v.getString() + ", ";
            }
        }

        System.out.println(string);
    }

    public static void print_BFS(Vertex vertex){
        Vertex[] vertices = BFS(vertex);


        String string = "";

        for (Vertex v : vertices){
            if (v != null) {
                string += v.getString() + ", ";
            }
        }

        System.out.println(string);
    }


    public static Vertex[] DFS(Vertex vertex){
        Vertex[] visited = new Vertex[10];
        int visited_size= 0;
        Stack adjacent = new Stack();

        Vertex curr = vertex;
        visited[visited_size] = curr;
        visited_size++;

        getAdjacentVertices(adjacent, null, visited, vertex);
        while (adjacent.size() > 0){

            while (visited(visited, curr) && !adjacent.empty()) {
                curr = (Vertex) adjacent.pop();

            }

            if (!visited(visited, curr)) {
                getAdjacentVertices(adjacent, null, visited, curr);
                visited[visited_size] = curr;
                visited_size++;
            }
        }

        return visited;

    }

    public static Vertex[] BFS(Vertex vertex){
        Vertex[] visited = new Vertex[10];
        int visited_size= 0;
        Queue<Vertex> adjacent = new ArrayDeque<Vertex>();

        Vertex curr = vertex;
        visited[visited_size] = curr;
        visited_size++;

        getAdjacentVertices(null, adjacent, visited, vertex);
        while (adjacent.size() > 0){


            while (visited(visited, curr) && !adjacent.isEmpty()) {
                curr = (Vertex) adjacent.remove();

            }

            if (!visited(visited, curr)) {
                getAdjacentVertices(null, adjacent, visited, curr);
                visited[visited_size] = curr;
                visited_size++;
            }

        }

        return visited;

    }

    public static void getAdjacentVertices(Stack adjacent_s, Queue adjacent_q, Vertex[] visited, Vertex vertex){

        for (int i = 0; i < vertex.getAdjacent_size();i++){
            boolean duplicate = visited(visited, vertex.getAdjacent()[i]);


            if (!duplicate && adjacent_s != null){
                adjacent_s.push(vertex.getAdjacent()[i]);
            }

            else if (!duplicate && adjacent_q != null){
                adjacent_q.add(vertex.getAdjacent()[i]);
            }
        }
    }


    public static boolean visited(Vertex[] visited, Vertex vertex){
        for (int j =0; j < visited.length; j++){
            if (vertex == visited[j]){
                return true;
            }
        }

        return false;
    }




}
