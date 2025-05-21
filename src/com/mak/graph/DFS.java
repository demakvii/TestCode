package com.mak.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {

/*        0
     1     2 - 3
  4   5    6 - 7*/

        int noOfNodes = 8;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < noOfNodes ; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);

        adj.get(1).add(0);
        adj.get(1).add(4);
        adj.get(1).add(5);

        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(2).add(6);

        adj.get(3).add(0);
        adj.get(3).add(2);
        adj.get(3).add(7);

        adj.get(4).add(1);

        adj.get(5).add(1);

        adj.get(6).add(2);
        adj.get(6).add(7);

        adj.get(7).add(3);
        adj.get(7).add(6);

        System.out.println(run(0, noOfNodes, adj));
        System.out.println(run(1, noOfNodes, adj));
    }

    private static List<Integer> run(int startingNode, int noOfNodes, List<List<Integer>> adj){
        boolean[] visited = new boolean[noOfNodes];
        List<Integer> result = new ArrayList<>();
        recursion(startingNode, visited, adj, result);
        return result;
    }

    private static void recursion(int currentNode, boolean[] visited, List<List<Integer>> adj, List<Integer> result){
        visited[currentNode] = true;
        result.add(currentNode);
        for (var neighbour : adj.get(currentNode)){
            if (!visited[neighbour]){
                recursion(neighbour, visited, adj, result);
            }
        }
    }

}
