package com.qxb.leetcode._111;

import java.util.LinkedList;

/**
 * Created by hacker on 7/29/2016.
 * <p>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution {
    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 1));

        while (queue.size() > 0) {

            Node node = queue.poll();
            int i = node.level;


            if (node.tnode.left != null) {
                queue.offer(new Node(node.tnode.left, i + 1));
            }
            if (node.tnode.right != null) {
                queue.offer(new Node(node.tnode.right, i + 1));
            }

            if (node.tnode.left ==null && node.tnode.right ==null){
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args){
        Solution so = new Solution();
        TreeNode tn1= new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        tn1.left = tn2;
        int res = so.minDepth(tn1);
        System.out.println(res);
    }
}

class Node {
    TreeNode tnode;
    int level;

    public Node(TreeNode tnode, int level) {
        this.tnode = tnode;
        this.level = level;
    }
}
