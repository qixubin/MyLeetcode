package com.qxb.leetcode._103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hacker on 7/29/2016.


 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],

  3
 / \
 9  20
   /  \
  15   7

 return its zigzag level order traversal as:

 [
 [3],
 [20,9],
 [15,7]
 ]


 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root ==null) return res;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0));

        while(queue.size() >0){

            Node node = queue.poll();
            int i = node.level;
            if (res.size() <i+1){
                List<Integer> li = new ArrayList<Integer>();
                li.add(node.tnode.val);
                res.add(li);
            }else{
                res.get(i).add(node.tnode.val);
            }

            if (node.tnode.left !=null){
                queue.offer(new Node(node.tnode.left, i+1));
            }
            if (node.tnode.right !=null){
                queue.offer(new Node(node.tnode.right, i+1));
            }
        }

        for(int i = 0; i< res.size() ; i++){
            if (i %2 ==1){
                List<Integer>  lii = res.get(i);
                Collections.reverse(lii);
            }
        }
        return res;
    }
}

class Node {
    TreeNode tnode;
    int level;
    public Node(TreeNode tnode, int level){
        this.tnode = tnode;
        this.level = level;
    }
}

