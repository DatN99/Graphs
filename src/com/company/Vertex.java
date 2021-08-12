package com.company;

public class Vertex {
    private String val;
    private Vertex[] adjacent = new Vertex[20];
    private int adjacent_size = 0;


    Vertex(String string){
        this.val = string;
    }

    public void add_edge(Vertex vertex){
        adjacent[adjacent_size] = vertex;
        adjacent_size++;


    }

    public Vertex[] getAdjacent(){
        return adjacent;
    }

    public int getAdjacent_size(){
        return adjacent_size;
    }

    public String getString(){
        return val;
    }


}
