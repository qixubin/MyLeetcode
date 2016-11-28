package com.qxb.leetcode._95;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 7/27/2016.

 Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1          3       3      2      1
  \        /      /      / \      \
   3     2     1       1    3      2
  /     /       \                   \
 2     1         2                   3


 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {

        if (n==0) {
            return new ArrayList<TreeNode>();
        }
        List<List<TreeNode>> cache = new ArrayList<List<TreeNode>>();

        TreeNode t1 = new TreeNode(1);
        ArrayList<TreeNode> al1 = new ArrayList<TreeNode>();
        al1.add(t1);

        TreeNode t2_1_1 = new TreeNode(1);
        TreeNode t2_1_2 = new TreeNode(2);
        t2_1_1.right = t2_1_2;

        TreeNode t2_2_1 = new TreeNode(1);
        TreeNode t2_2_2 = new TreeNode(2);
        t2_2_2.left = t2_2_1;
        ArrayList<TreeNode> al2 = new ArrayList<TreeNode>();
        al2.add(t2_1_1);
        al2.add(t2_2_2);

        cache.add(al1);
        cache.add(al2);


        for(int i =3 ; i <=n ; i++){
            ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
            List<TreeNode> prev = cache.get(i-2);
            for(TreeNode tn : prev){
                TreeNode addToTop = deepCopy(tn,0);
                TreeNode top = new TreeNode(i);
                top.left = addToTop;
                cur.add(top);


                TreeNode addToBottom = deepCopy(tn,0);
                TreeNode step = addToBottom;
                TreeNode bottom = new TreeNode(i);
                while(step.right !=null){
                    step = step.right;
                }
                step.right = bottom;
                cur.add(addToBottom);
            }




            for(int k  =1; k< i-1; k++){
                int topCount = cache.get(k-1).size();
                int bottomCount = cache.get(i-1-k-1).size();

                for(int p=0; p < topCount; p++){
                    for(int q=0; q < bottomCount; q++){
                        TreeNode top = deepCopy(cache.get(k-1).get(p),0);
                        TreeNode step = top;
                        while(step.right !=null) step = step.right;
                        TreeNode bottom = deepCopy(cache.get(i-1-k-1).get(q), k);
                        TreeNode mid = new TreeNode(i);
                        mid.left = bottom;
                        step.right = mid;
                        cur.add(top);
                    }
                }
            }

            cache.add(cur);

        }

        return cache.get(n-1);
    }

    public TreeNode deepCopy(TreeNode n1, int inc){

        if (n1 ==null) return null;
        TreeNode res = new TreeNode(n1.val +inc);
        TreeNode left = deepCopy(n1.left, inc);
        TreeNode right = deepCopy(n1.right, inc);
        res.left = left;
        res.right = right;
        return res;
    }

    public static void main(String[] args){
        Solution so = new Solution();
//
//        TreeNode tn1 = new TreeNode(1);
//        TreeNode tn2 = new TreeNode(2);
//        TreeNode tn3 = new TreeNode(3);
//
//        tn1.right = tn2;
//        tn2.left = tn3;
//
//        TreeNode res =so.deepCopy(tn1,3);
        List<TreeNode> res =so.generateTrees(5);
        System.out.println(res.size());
    }

}
