package com.Ayoub;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> paths = new ArrayList<>();
        ArrayList<String> states = new ArrayList<>();

        // machine 1
        Node s0 = new Node("S0");
        Node s1 = new Node("S1");
        Node s2 = new Node("S2");
        Node s3 = new Node("S3");

        // machine 2
        Node running = new Node("R");
        Node walking = new Node("W");
        Node sitting = new Node("S");
        Node jumping = new Node("J");

        s0.con.put('B',s1);
        s0.con.put('A',s2);
        s1.con.put('A',s1);
        s1.con.put('B',s2);
        s2.con.put('B',s3);
        s3.con.put('A',s3);
        s3.con.put('B',s0);

        s0.nodeRoute("ABABBABBAXABB", paths);

        running.con.put('1',jumping);
        running.con.put('2',walking);
        walking.con.put('1',running);
        walking.con.put('2',sitting);
        sitting.con.put('1',walking);
        jumping.con.put('1',sitting);
        jumping.con.put('2',running);

        sitting.nodeRoute("1212125", states);
    }
}