package com.qxb.leetcode._112;

import java.util.LinkedList;

/**
 * Created by hacker on 7/29/2016.

 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 For example:
 Given the below binary tree and sum = 22,

             5
           / \
          4   8
        /    / \
      11    13  4
    /  \         \
   7    2         1

 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0));

        while (queue.size() > 0) {

            Node node = queue.poll();
            int i = node.prevSum;


            if (node.tnode.left != null) {
                queue.offer(new Node(node.tnode.left, i +node.tnode.val));
            }
            if (node.tnode.right != null) {
                queue.offer(new Node(node.tnode.right, i + node.tnode.val));
            }

            if (node.tnode.left ==null && node.tnode.right ==null && (node.tnode.val + i  == sum)){
                return true;
            }
        }
        return false;
    }

}

class Node {
    TreeNode tnode;
    int prevSum;

    public Node(TreeNode tnode, int sum) {
        this.tnode = tnode;
        this.prevSum = sum;
    }
}
