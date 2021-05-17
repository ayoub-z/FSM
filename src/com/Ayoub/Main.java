package com.Ayoub;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> paths = new ArrayList<>();
        Node s0 = new Node("S0");
        Node s1 = new Node("S1");
        Node s2 = new Node("S2");
        Node s3 = new Node("S3");

        s0.con.put('B',s1);
        s0.con.put('A',s2);
        s1.con.put('A',s1);
        s1.con.put('B',s2);
        s2.con.put('B',s3);
        s3.con.put('A',s3);
        s3.con.put('B',s0);

        s0.nodeRoute("ABABBABBAABB", paths);
    }
}