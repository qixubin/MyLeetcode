package com.qxb.leetcode._49;

import java.util.*;

/**
 * Created by hacker on 6/28/2016.
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 Note: All inputs will be in lower-case.
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        for (String str: strs){
            char[] c_a = str.toCharArray();
            Arrays.sort(c_a);
            String ordered = new String(c_a);
            if  (hm.containsKey(ordered)){
                hm.get(ordered).add(str);
            }else{
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                hm.put(ordered, al);
            }
        }
        List<List<String>> list = new ArrayList<List<String>>(hm.values());

        return list;
    }

    public static void main(String[] argc){
        Solution s1 = new Solution();
        String[] strs = {"ate", "eat","tea", "tan","nat","bat"};

//        String abc = "system";
//        char[] c_a = abc.toCharArray();
//        Arrays.sort(c_a);
//        System.out.println(c_a);

        List<List<String>> a =s1.groupAnagrams(strs);
        System.out.println("a");
    }

}
