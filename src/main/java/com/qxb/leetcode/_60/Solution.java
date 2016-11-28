package com.qxb.leetcode._60;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 7/1/2016.
 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"

 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.

 */

//time limit exceeded
//leetcode solution use loop not recursion, use char[] not use ArrayList

public class Solution {
    public String getPermutation(int n, int k) {
        int[] perms = new int[n];
        perms[0] =1;
        for (int i=1; i< n; i++){
            perms[i] = perms[i-1]*(i+1);
        }
        ArrayList<Integer> li = new ArrayList<Integer>();
        for (int i =1; i <=n;i++){
            li.add(i);
        }

        if(n==1){
            if (k==1)
                return "1";
        }
        return helper(perms, n, k, li);
    }

    public String helper( int[] perms, int n, int k , List<Integer> li){
        if (n==2){
            if (k==1){
                return new Integer(li.get(0)).toString() + (new Integer(li.get(1).toString()));
            }else if (k==2){
                return new Integer(li.get(1)).toString() + (new Integer(li.get(0).toString()));
            }
        }


        int div = perms[n-2];

        int k_d = (k-1)/div;

        String prev = new Integer(li.get(k_d)).toString();
        li.remove(k_d);
        return  prev+ helper(perms, n-1, k-k_d*div , li);
    }

//    public int perm(int n){
//        int result =1;
//        while(n>=1){
//            result = result* n;
//            n--;
//        }
//        return result;
//    }

    public static void main(String[] argv){

        Solution so = new Solution();
//        System.out.println(so.perm(4));

        System.out.println(so.getPermutation(8,8590));


    }
}
