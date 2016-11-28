package com.qxb.leetcode._102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hacker on 7/29/2016.

 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],

  3
 / \
 9  20
   /  \
  15   7

 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]


 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

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