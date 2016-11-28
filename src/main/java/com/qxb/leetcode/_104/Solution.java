package com.qxb.leetcode._104;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hacker on 7/29/2016.

 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 */
public class Solution {
    public int maxDepth(TreeNode root) {

        if (root ==null) return 0;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0));
        int res = 0;
        while(queue.size() >0){

            Node node = queue.poll();
            int i = node.level;

            if (node.tnode.left !=null){
                res = i+1;
                queue.offer(new Node(node.tnode.left, i+1));
            }
            if (node.tnode.right !=null){
                res = i+1;
                queue.offer(new Node(node.tnode.right, i+1));
            }
        }
        return res+1;
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