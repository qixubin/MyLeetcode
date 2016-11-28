package com.qxb.leetcode._106;

import java.util.Arrays;

/**
 * Created by hacker on 7/29/2016.

 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int len = inorder.length;
        if (len ==0) return null;
        if (len ==1) return new TreeNode(inorder[0]);

        int last = postorder[len-1];
        int index = getIndex(inorder, last);

        TreeNode tn = new TreeNode(last);
        int[] left_post = Arrays.copyOfRange(postorder,0,index);
        int[] right_post = Arrays.copyOfRange(postorder,index,len-1);

        int[] left_in = Arrays.copyOfRange(inorder, 0,index );
        int[] right_in = Arrays.copyOfRange(inorder,index +1, len);

        tn.left = buildTree( left_in, left_post);
        tn.right = buildTree( right_in, right_post);


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


        int[] in = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] post = new int[]{0, 2, 4, 6, 5, 3, 1, 8, 10, 9, 7};
        Solution so = new Solution();
        TreeNode tn =so.buildTree(in, post);
        System.out.println(tn.val);
    }
}
