package com.qxb.leetcode._373;

import java.util.*;

/**
 * Created by hacker on 7/22/2016.

 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

 Example 1:

 Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

 Return: [1,2],[1,4],[1,6]

 The first 3 pairs are returned from the sequence:
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

 Example 2:

 Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

 Return: [1,1],[1,1]

 The first 2 pairs are returned from the sequence:
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

 Example 3:

 Given nums1 = [1,2], nums2 = [3],  k = 3

 Return: [1,3],[2,3]

 All possible pairs are returned from the sequence:
 [1,3],[2,3]


 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res =new ArrayList<int[]>();

        if (k==0) return res;

        int m = nums1.length;
        int n = nums2.length;

        if (m==0 || n ==0) return res;
        TreeSet<Point> ts =new TreeSet<Point>();
        int count =0;

        ts.add(new Point(nums1[0]+nums2[0], 0, 0));

        while(count < m*n && count <k){
            Point p = ts.first();

            int pm = p.m;
            int pn = p.n;

            res.add(new int[]{nums1[pm], nums2[pn]});
            count ++;

            if(pm +1<m ){
                ts.add(new Point(nums1[pm+1] + nums2[pn], pm+1, pn));
            }

            if(pn+1 < n){
                ts.add(new Point(nums1[pm] + nums2[pn+1], pm, pn+1));
            }
            ts.remove(p);


        }
        return res;
    }

    public static void main(String[] args){
        Solution so = new Solution();

        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};

        List<int[]> res = so.kSmallestPairs(nums1, nums2, 9);
        System.out.println("aa");
    }
}

class Point implements Comparable<Point>{
    int value;
    int m;
    int n;
    public Point(int value,int  m ,int n){
        this.value = value;
        this.m = m;
        this.n = n;
    }
    @Override
    public int compareTo( Point o) {
        if (this.value == o.value){
            if(this.m == o.m){
                return Integer.compare(this.n, o.n);
            }else{
                return Integer.compare(this.m, o.m);
            }
        }else{
            return Integer.compare(this.value, o.value);
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        Point p = (Point) obj;
        return (this.value == p.value && this.m == p.m && this.n ==p.n);
    }

}
