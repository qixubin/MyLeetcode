package com.qxb.leetcode._91;

/**
 * Created by hacker on 7/26/2016.

 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26

 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.

 */
public class Solution {

    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (len ==1) {
            if (s.equals("0"))
                return 0;
            return 1;
        }

        int[] count = new int[len];

        boolean[] onetwo = new boolean[len];
        int prevInt =-1;
        for(int i = 0; i< len; i++){
            int cur = Integer.valueOf(s.substring(i,i+1));

            if (cur <3 && cur >0){
                onetwo[i] = true;
            }

            if( i ==0) {
                count[i] =1;
                if (cur ==0)
                    return 0;
            }else if (i==1){
                if (cur ==0 && !(prevInt ==1 || prevInt ==2))
                    return 0;

                if (prevInt ==1){
                    if (cur ==0){
                        count[i] =1;
                    }else{
                        count[i] =2;
                    }

                }else if( prevInt ==2){
                    if( cur>=1 && cur <=6) {
                        count[i] = 2;
                    }else{
                        count[i] =1;
                    }
                }else{
                    count[i] =1;
                }
            }else{

                if (cur ==0 && !(prevInt ==1 || prevInt ==2))
                    return 0;
                if (onetwo[i-2] && onetwo[i-1]){
                    if (onetwo[i]){
                        count[i] = count[i-2] +count [i-1];
                    }else{
                        if (prevInt ==1){
                            if (cur ==0){

                                count[i] = count[i-2];
                                if (count[i-2] ==1)
                                    count[i-1]=1;
                            }else{
                                count[i] = count[i-2] +count [i-1];
                            }
                        }else if(prevInt ==2){
                            if(cur ==0){

                                count[i] = count[i-2];
                                if (count[i-2] ==1)
                                    count[i-1]=1;

                            }else if(cur >=3 && cur <=6){
                                count[i] = count[i-2] +count [i-1];
                            }else{
                                count[i] = count[i-1];
                            }
                        }
                    }

                }else if (!onetwo[i-1]){
                    count[i] =1;
                }else if( !onetwo[i-2] && onetwo[i-1]){
                    if (prevInt ==1){
                        if (cur ==0){
                            count[i] =1;
                        }else{
                            count[i] =2;
                        }
                    }else if(prevInt ==2){
                        if (cur ==0 || cur >6){
                            count[i] =1;
                        }else if (cur <=6){
                            count[i] =2;
                        }


                    }else{
                        if( cur>=1 || cur <=6) {
                            count[i] = 2;
                        }else{
                            count[i] =1;
                        }
                    }
                }
            }

            prevInt = cur;
        }
        int res =1;
        for(int i =0; i < count.length-1;i++){
            if (count[i+1] ==1){
                res *= count[i];
            }
        }
        if (count[count.length-1] >1)
            res *= count[count.length-1];
        return res;
    }

    public static void main(String[] args){
        Solution so = new Solution();
        String s = "1213127262016";
//        s = "2120";
        s="27";
        s = "110";
        int res  = so.numDecodings(s);
        System.out.println(res);
    }
}
