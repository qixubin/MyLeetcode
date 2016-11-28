package com.qxb.leetcode._116;

import java.util.LinkedList;

/**
 * Created by hacker on 8/1/2016.


 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }

 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

 For example,
 Given the following perfect binary tree,

      1
    /  \
   2    3
 / \  / \
 4  5  6  7

 After calling your function, the tree should look like:

      1 -> NULL
    /  \
   2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL


 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0));

        TreeLinkNode prev = null;
        int prevLevel = -1;
        while (queue.size() > 0) {
            Node node = queue.poll();


            int i = node.level;

            if (node.level == prevLevel) {
                prev.next = node.tln;
            }

            if (node.tln.left != null) {
                queue.offer(new Node(node.tln.left, i + 1));
            }
            if (node.tln.right != null) {
                queue.offer(new Node(node.tln.right, i + 1));
            }

            prev = node.tln;
            prevLevel = i;

        }
    }

}

class Node{
    TreeLinkNode tln;
    int level;
    public Node(TreeLinkNode tln, int level){
        this.tln = tln;
        this.level = level;
    }
}
