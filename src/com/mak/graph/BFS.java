package com.mak.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    //Breadth wise traversing or level wise
    //Maintains visited nodes
    //Use Queue as DS
    public static void main(String[] args) {
/*          0
       1      5
    2    3   6   8
        4 -- 7*/
        int noOfNodes = 9;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <noOfNodes ; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(5);

        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);

        adj.get(3).add(1);
        adj.get(3).add(4);

        adj.get(4).add(3);
        adj.get(4).add(7);

        adj.get(5).add(0);
        adj.get(5).add(6);
        adj.get(5).add(8);

        adj.get(6).add(5);
        adj.get(6).add(7);

        adj.get(7).add(6);
        adj.get(7).add(4);

        adj.get(8).add(5);

        System.out.println(run(noOfNodes, adj, 0));
        System.out.println(run(noOfNodes, adj, 1));
        System.out.println(run(noOfNodes, adj, 8));
    }

    private static List<Integer> run(int noOfNodes, List<List<Integer>> adj, int startingNode){

        boolean[] visited = new boolean[noOfNodes];

        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        visited[startingNode] = true;
        queue.add(startingNode);

        while (!queue.isEmpty()){
            Integer element = queue.poll();
            result.add(element);
            for(var neighbour : adj.get(element)){
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }


        return result;
    }

}
