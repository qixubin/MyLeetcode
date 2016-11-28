package com.qxb.leetcode._43;

/**
 * Created by qixubin on 2016/5/30.
 *
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note:
 The numbers can be arbitrarily large and are non-negative.
 Converting the input string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.

 */
public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if (len2 > len1)
            return multiply(num2, num1);

        String[] s2 = new String[len2];

        String suffix = "";
        for (int i = len2-1; i >=0; i--){
            String mu = mulS(num1, num2.substring(i, i +1));
            s2[i] = mu + suffix;
            suffix = suffix +"0";

        }

        String result = "0";

        for (String s : s2){
            result = add(result, s);
        }

        return result;
    }

    public String mulS(String num1, String s1){
        int n1 = Integer.parseInt(s1);
        if (n1 ==0)
            return "0";
        String result = num1;
        while( n1>1){
            result = add(result, num1);
            n1 --;
        }
        return result;
    }

    public String add(String a, String b){
        if (a.equals("0")){
            return b;
        }

        if (b.equals("0")){
            return a;
        }

        int len_a = a.length();
        int len_b = b.length();

        if (len_a -len_b >=0){
            for( int i  =0 ; i<len_a-len_b; i++){
                b  = "0" +b;
            }
        }else{
            add(b,a);
        }

        int[] forward = new int[len_a+1];
        char[] result = new char[len_a+1];
        for(int i = len_a-1; i >=0; i--){
            int a_i = str2int(a, i);
            int b_i = str2int(b, i);
            int sum = a_i+b_i + forward[i+1];
            result[i+1] = new Integer(sum%10).toString().charAt(0);
            forward[i] = sum/10;
        }

        if (forward[0] ==1){
            result[0] = '1';
            return new String(result);
        }else{
            return new String(result).substring(1,len_a+1);
        }

    }

    public int str2int(String a, int index){
        return Integer.parseInt(a.substring(index, index +1));
    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
        String a = "111222";
        String b = "2222";
//        System.out.println(s1.add(a, b));
//        System.out.println(s1.mulS(a,"5"));
        System.out.println(s1.multiply(a,b));
//        String s = "hello";
//        String backup_of_s = s;
//        backup_of_s = "bye";
//        System.out.println(s);

//        int aa = 53;
//        char bb = (char) aa;
//        System.out.println(bb);
    }
}
