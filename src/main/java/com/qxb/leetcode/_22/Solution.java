package com.qxb.leetcode._22;

import java.util.*;

/**
 * Created by qixubin on 2016/5/7.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {

        LinkedList<String> list = new LinkedList<String>();

        generateParenthesisReccursive(1, n, list);


        Set<String> hs = new HashSet<>();

        hs.addAll(list);

        list.clear();
        list.addAll(hs);
        return list;

    }

    public void generateParenthesisReccursive(int m, int n, LinkedList<String> list) {
        if (m > 2*n)
            return;
        if (m == 1) {
            list.add("(");
            generateParenthesisReccursive(m + 1, n, list);
        } else {
            while (list.peek().length() == m - 1) {
                String cur = list.pop();
                int c_left = numOfPara(cur,"\\(");
                int c_right = numOfPara(cur, "\\)");

                if (c_left ==n){
                    list.add(cur + ")");
                }else if(c_left==c_right){
                    list.add(cur + "(");
                }else{
                    list.add(cur + "(");
                    list.add(cur + ")");
                }
            }
            generateParenthesisReccursive(m + 1, n, list);
        }
    }

    public int numOfPara(String s, String c){
        int count = s.length() - s.replaceAll(c,"").length();
        return count;
    }

    public static void main(String[] argc) {
        Solution s1 = new Solution();

        //System.out.println(s1.numOfPara("((()", "\\("));
        List<String> li = s1.generateParenthesis(4);

        for (String e : li) {
            System.out.println(e);
        }

//        queue.add("1");
//        queue.add("2");
//        queue.add("3");
//        System.out.println(queue.pop());
//        System.out.println(queue.getLast());

//        String a = "abcd";
//        int len = a.length();
//        System.out.println(a.substring(0+len-2,len));
    }
}