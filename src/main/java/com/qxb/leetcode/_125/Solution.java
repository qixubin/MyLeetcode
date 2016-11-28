package com.qxb.leetcode._125;

/**
 * Created by hacker on 8/15/2016.

 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.

 */
public class Solution {

    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        char[] chars = s.toCharArray();
        int i = 0;
        int len = chars.length;
        int j = len-1;

        while( j>i){

            while(i <chars.length){
                char c = chars[i];
                if (    (c >=65 && c<=90)
                        || (c>=97 && c<=122)
                        || (c>=48 && c<=57)
                        ){
                    break;
                }else{
                    i++;
                }
            }

            if (i >= len -1) return true;

            while(j >=0){
                char c = chars[j];
                if (    (c >=65 && c<=90)
                        || (c>=97 && c<=122)
                        || (c>=48 && c<=57)
                        ){
                    break;
                }else{
                    j--;
                }
            }

            if (j <=0) return true;

            if (i ==j) return true;

            if (!isEqual(chars[i], chars[j])){
                return false;
            }else{
                i++;
                j--;
            }


        }

        return true;
    }



    public boolean isEqual(char a, char b){
        return (a==b)
                || (a >=65 && a<=90 && a+32 ==b)
                || (a >=97 && a<=122 && a-32 ==b);
    }


    public static void main(String[] args){
        Solution so = new Solution();
        boolean res = so.isPalindrome("......a.....");
        res = so.isPalindrome("abA");
        res = so.isPalindrome("race a car");
        res = so.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(res);
    }

}
