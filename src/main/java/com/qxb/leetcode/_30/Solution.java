package com.qxb.leetcode._30;

import java.util.*;

/**
 * Created by qixubin on 2016/5/18.
 *
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of
 * each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).

 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int size = words.length;
        int width = words[0].length();
        int t_size = size*width;

        for(int i =0; i+t_size<= s.length(); i++){
            String current = s.substring(i,i+t_size);
            if (check(current, words))
                result.add(i);
        }
        return result;
    }

    public boolean check(String s, String[] words){
        int width = words[0].length();
        String[] c_words= str2arr(s, width);

        String r1 =sortarr2str(c_words);
        String r2= sortarr2str(words);

        return r1.equals(r2);
    }

    public String[] str2arr(String s ,int width){
        int len = s.length()/width;
        String[] result = new String[len];
        for(int i=0; i< len; i++){
            result[i]= s.substring(i*width, (i+1)*width);
        }
        return result;
    }

    public String sortarr2str(String[] words){
        StringBuffer sb= new StringBuffer();
        Set<String> set = new TreeSet<String>();
        for(String word:words){
            set.add(word);
        }
        Iterator<String> itr=set.iterator();
        while(itr.hasNext()){
            String c=itr.next();
            sb.append(c);

        }
        return sb.toString();
    }

    public static void main(String[] argc){
        Solution s1 = new Solution();
        //System.out.println("abc".substring(0,3));

//        String s = "ghiabcdefaad";
//        String[] aa= s1.str2arr(s,3);
//        System.out.println(aa[0]);
//        System.out.println(aa[1]);
//        //System.out.println(aa[2]);
//        System.out.println(s1.sortarr2str(aa));

        String s = "barfoothefoobarman";
        String[] a = new String[2];
        a[0]="foo";
        a[1]="bar";
        List<Integer> result = s1.findSubstring(s, a);
        System.out.println(result.size());
    }
}
