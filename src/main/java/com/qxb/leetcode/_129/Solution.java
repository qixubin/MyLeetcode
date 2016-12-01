package com.qxb.leetcode._129;

import java.util.LinkedList;

/**

 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

    1
  / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.

 * Created by qxb on 2016/12/1.
 */
public class Solution {

    //my solution ,  not clear.  also the problem said that only 0-9, so not need to parse string, only *10 and add
    public int sumNumbers(TreeNode root) {
        if (root ==null) return 0;
        int result =0;
        LinkedList<ValuedNode> queue = new LinkedList<ValuedNode>();
        queue.add(new ValuedNode(new Integer(root.val).toString(), root));

        while(!queue.isEmpty()){
            ValuedNode top = queue.poll();
            String value = top.high;
            TreeNode node = top.node;

            if (node.left !=null){
                queue.add(new ValuedNode(value + new Integer(node.left.val).toString(), node.left));
            }

            if(node.right !=null){
                queue.add(new ValuedNode(value + new Integer(node.right.val).toString(), node.right));
            }

            if (node.left ==null && node.right ==null){
                result += Integer.parseInt(value);
            }

        }

        return result;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;

        Solution so = new Solution();
        System.out.println(so.sumNumbers(t1));

    }
}

class ValuedNode{
    String high;
    TreeNode node;
    public ValuedNode(String s, TreeNode n){
        this.high = s;
        this.node = n;
    }
}
