package problems.LongestRouteInGraph;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


public class LongestRouteNewSolution {

	public LongestRouteNewSolution() {
		// TODO Auto-generated constructor stub
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Node> groups = new HashSet<>(n / 2);
        Node[] nodes = new Node[n * 2];
        for (int i = 0; i < n * 2; i++) {
            nodes[i] = new Node();
            //Group g = new Group(nodes[i]);
        }
        for (int i = 0; i < n; i++) {
            merge(groups, findGroup(nodes[sc.nextInt()-1]), findGroup(nodes[sc.nextInt()-1]));
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (Node node : groups) {
            if (min > node.size)
                min = node.size;
            if (max < node.size)
                max = node.size;
        }
        System.out.println(min + " " + max);
    }
    
    private static class Node {
        Node p;
        int rank = 0;
        int size;
        
        Node() {
            p = this;
            size = 1;
        }
        
    }
    private static void merge(Set<Node> groups, Node c1, Node c2) {
        if (c1 == c2)
            return;
        if (c1.rank > c2.rank) {
            c2.p = c1;
            c1.size += c2.size;
            groups.add(c1);
            groups.remove(c2);
            return;
        } else {
            c1.p = c2;
            c2.size += c1.size;
            groups.add(c2);
            groups.remove(c1);
            if (c1.rank == c2.rank)
                c2.rank++;
            return;
        }
    }
    
    private static Node findGroup(Node n) {
        if (n.p != n) {
            return findGroup(n.p);
        } else {
            return n;
        }
    }

}
