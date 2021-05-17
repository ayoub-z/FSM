package com.Ayoub;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class NodeTest {
    private final Node s0 = new Node("S0");
    private final Node s1 = new Node("S1");
    private final Node s2 = new Node("S2");
    private final Node s3 = new Node("S3");
    private final ArrayList<String> paths = new ArrayList<>();

    @Test
    public void getName() {
        assertEquals("S0", s0.getName());
        assertEquals("S1", s1.getName());
        assertEquals("S2", s2.getName());
        assertEquals("S3", s3.getName());
    }

    @Test
    public void nodeRoute() {
        s0.con.put('B',s1);
        s0.con.put('A',s2);
        s1.con.put('A',s1);
        s1.con.put('B',s2);
        s2.con.put('B',s3);
        s3.con.put('A',s3);
        s3.con.put('B',s0);

        assertEquals(Arrays.asList("S0", "S2", "S3", "S3", "S0", "S1", "S1", "S2", "S3", "S3", "e"),s0.nodeRoute("ABABBABBAXABB",paths));
    }

    @Test
    public void testToString() {
        String currentPosition = "S0";
        Character route = 'A';
        String nextPosition = "S2";
        assertEquals(("Currently on: S0\nAfter input A we're on: S2\n"),s0.toString(currentPosition,route,nextPosition));
    }

}