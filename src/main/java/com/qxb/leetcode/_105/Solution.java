package com.qxb.leetcode._105;

import java.util.Arrays;

/**
 * Created by hacker on 7/29/2016.


 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int len = preorder.length;
        if (len ==0) return null;
        if (len ==1) return new TreeNode(preorder[0]);

        int first = preorder[0];
        int index = getIndex(inorder, first);

        TreeNode tn = new TreeNode(first);
        int[] left_pre = Arrays.copyOfRange(preorder,1,index+1);
        int[] right_pre = Arrays.copyOfRange(preorder,index+1,len);

        int[] left_in = Arrays.copyOfRange(inorder, 0,index );
        int[] right_in = Arrays.copyOfRange(inorder,index +1, len);

        tn.left = buildTree(left_pre, left_in);
        tn.right = buildTree(right_pre, right_in);


        return tn;
    }

    public int getIndex(int[] orders, int target){

        for(int i = 0 ; i< orders.length; i++){
            if (orders[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
//        int[] test = new int[]{1,2,3,4};
//        int[] copy = Arrays.copyOfRange(test, 0, 3);
//        System.out.println("123");

        int[] pre = new int[]{7, 1, 0, 3, 2, 5, 4, 6, 9, 8, 10};
        int[] in = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Solution so = new Solution();
        TreeNode tn =so.buildTree(pre, in);
        System.out.println(tn.val);
     }
}
