package com.qxb.leetcode._99;

import java.util.ArrayList;

/**
 * Created by hacker on 7/28/2016.

 Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.
 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

 */
public class Solution {

    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> li = new ArrayList<TreeNode>();
        helper(root, li);

        int len = li.size();

        int k=0;

        for(int i = 0; i < len-1; i++){
            if (li.get(i).val > li.get(i+1).val){
                k =i;
                break;
            }
        }

        int m=0;
        for(int i = len-1; i >0; i--){
            if (li.get(i).val < li.get(i-1).val){
                m =i;
                break;
            }
        }

        int k_val = li.get(k).val;
        int m_val = li.get(m).val;
        li.get(k).val = m_val;
        li.get(m).val = k_val;
    }

    public void helper(TreeNode node, ArrayList<TreeNode> li){
        if (node == null) return;

        helper(node.left, li);
        li.add(node);
        helper(node.right, li);
    }

}
