package com.Ayoub;


import java.util.ArrayList;
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

    public void nodeRoute(String route, ArrayList<String> traveledNodes) {
        // convert string containing route into charArray
        char[] ch = new char[route.length()];
        for (int i = 0; i < route.length(); i++) {
            ch[i] = route.charAt(i);
        }

        int counter = 0;

        Node position = con.get(ch[0]);

        for (char i : ch) {
            counter++;
            // HARDCODED for the first starting point
            if (counter == 1) {
                // check if given route (for example 'A') is a valid route from our position
                if(con.containsKey(i)){
                    System.out.println(toString(getName(),i,con.get(i).getName()));

                    // ArrayList to keep track of nodes we've visited
                    traveledNodes.add(getName());
                    traveledNodes.add(con.get(i).getName());

                    // update the node position we're currently on
                    position = con.get(i);
                }
            }
            else{ // for each position after the starting point
                if (position.con.containsKey(i)) {
                    System.out.println(toString(position.getName(),i,position.con.get(i).getName()));
                    traveledNodes.add(position.con.get(i).getName());
                    position = position.con.get(i);

                }
                else {
                    System.out.println(toString(position.getName(),i,null));
                    traveledNodes.add("e");
                    break;
                }
            }
        }
        System.out.println("After following the given route, we have reached these nodes: " + traveledNodes);
    }

    public String toString(String position, Character route, String node) {
        if (node == null){
            return route + " is not a valid route from " + position + "\nEnding sequence...\n";
        }
        else {
            return "Currently at: " + position + "\nAfter taking route " + route + " we're on: " + node + "\n";
        }
    }
}