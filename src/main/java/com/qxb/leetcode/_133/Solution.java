package com.qxb.leetcode._133;

import java.util.*;

/**

 Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:

     1
    / \
  /    \
 0 ---  2
       / \
       \_/

 * Created by qxb on 2016/12/7.
 */
public class Solution {

    Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

    Map<Integer, String> visited = new HashMap<Integer, String>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;


        queue.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode ugn =  queue.poll();
            if(visited.containsKey(ugn.label)){
                continue;
            }

            String neigh= "";
            for( UndirectedGraphNode nn: ugn.neighbors){
                neigh +=nn.label +",";
                queue.add(nn);
            }
            visited.put(ugn.label, neigh);
        }

        for(int i : visited.keySet()){
            map.put(i, new UndirectedGraphNode(i));
        }


        int index = Integer.MAX_VALUE;
        for(int i : visited.keySet()){
            if (i < index){
                index = i;
            }

            String neigh = visited.get(i);
            if (neigh.equals("")) continue;
            String[] nn = neigh.split(",");
            for(String n: nn){
                map.get(i).neighbors.add(map.get(Integer.parseInt(n)));
            }
        }

//        UndirectedGraphNode[] rr = new UndirectedGraphNode[map.size()];
//        map.values().toArray(rr);
//        return rr[0];

        return map.get(index);
    }

    public static void main(String[] args){
        Solution so = new Solution();
        UndirectedGraphNode u0 = new UndirectedGraphNode(0);
        UndirectedGraphNode u1 = new UndirectedGraphNode(1);
        UndirectedGraphNode u2 = new UndirectedGraphNode(2);
        UndirectedGraphNode u3 = new UndirectedGraphNode(3);
        UndirectedGraphNode u5 = new UndirectedGraphNode(5);
        UndirectedGraphNode u1m = new UndirectedGraphNode(-1);
        UndirectedGraphNode u3m = new UndirectedGraphNode(-3);
//        u0.neighbors.add(u1);
//        u0.neighbors.add(u2);
//
//        u1.neighbors.add(u0);
//        u1.neighbors.add(u2);
//
//        u2.neighbors.add(u0);
//        u2.neighbors.add(u1);
//        u2.neighbors.add(u2);

        u3m.neighbors.add(u1m);
        u3m.neighbors.add(u3);
        u3m.neighbors.add(u5);

        u1m.neighbors.add(u2);
        u1m.neighbors.add(u3);
        u1m.neighbors.add(u3);

        u2.neighbors.add(u3);

        u3.neighbors.add(u5);

        UndirectedGraphNode result = so.cloneGraph(u3m);
        System.out.println(result.label);
    }
}


