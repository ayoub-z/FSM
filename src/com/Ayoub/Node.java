package com.Ayoub;


import java.util.HashMap;

public class Node {
    private final String name;
    HashMap<Character, Node> con = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }


}