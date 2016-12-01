package com.qxb.leetcode._129;

/**
 * Created by qxb on 2016/12/1.
 */
public class Solution1 {


    //leetcode solution, much clear than mine
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(22);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left =t4;
        t3.left = t5;

        Solution1 s1 = new Solution1();
        System.out.println(s1.sumNumbers(t1));

    }
}
