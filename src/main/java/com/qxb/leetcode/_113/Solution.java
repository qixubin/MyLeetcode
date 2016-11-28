package com.qxb.leetcode._113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hacker on 7/29/2016.

 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 For example:
 Given the below binary tree and sum = 22,

         5
        / \
      4   8
    /    / \
   11   13  4
 /  \      / \
 7   2    5   1

 return

 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) return res;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0, new ArrayList<Integer>()));

        while (queue.size() > 0) {

            Node node = queue.poll();
            int i = node.prevSum;


            if (node.tnode.left != null) {
                ArrayList<Integer> copy = new ArrayList<>(node.prevValues);
                copy.add(node.tnode.val);
                queue.offer(new Node(node.tnode.left, i +node.tnode.val, copy));
            }
            if (node.tnode.right != null) {
                ArrayList<Integer> copy = new ArrayList<>(node.prevValues);
                copy.add(node.tnode.val);
                queue.offer(new Node(node.tnode.right, i + node.tnode.val, copy));
            }

            if (node.tnode.left ==null && node.tnode.right ==null && (node.tnode.val + i  == sum)){
                node.prevValues.add(node.tnode.val);
                res.add(node.prevValues);
            }
        }
        return res;
    }
}

class Node {
    TreeNode tnode;
    int prevSum;
    List<Integer> prevValues;

    public Node(TreeNode tnode, int sum, List<Integer> prevValues) {
        this.tnode = tnode;
        this.prevSum = sum;
        this.prevValues = prevValues;
    }
}
