package com.qxb.leetcode._96;

/**
 * Created by hacker on 7/27/2016.


 Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3       3      2      1
  \       /      /      / \      \
   3     2     1      1   3       2
  /     /       \                  \
 2     1         2                  3

 */
public class Solution {

    public int numTrees(int n) {

        int[] cache = new int[n+1];
        if (n==1 || n==2) return n;

        cache[1] =1;
        cache[2] =2;


        for(int i =3 ; i <=n ; i++){
            int count = cache[i-1] *2;

            for(int k  =1; k< i-1; k++){
                count += cache[k] *cache[i-1-k];
            }

            cache[i] = count;

        }

        return cache[n];
    }

    public static void main(String[] args){
        Solution so = new Solution();
        int res = so.numTrees(5);
        System.out.println(res);
    }
}
