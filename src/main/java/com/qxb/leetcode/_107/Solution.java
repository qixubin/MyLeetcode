package com.qxb.leetcode._107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hacker on 7/29/2016.
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its bottom-up level order traversal as:
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0));

        while (queue.size() > 0) {

            Node node = queue.poll();
            int i = node.level;
            if (res.size() < i + 1) {
                List<Integer> li = new ArrayList<Integer>();
                li.add(node.tnode.val);
                res.add(li);
            } else {
                res.get(i).add(node.tnode.val);
            }

            if (node.tnode.left != null) {
                queue.offer(new Node(node.tnode.left, i + 1));
            }
            if (node.tnode.right != null) {
                queue.offer(new Node(node.tnode.right, i + 1));
            }
        }
        Collections.reverse(res);
        return res;
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