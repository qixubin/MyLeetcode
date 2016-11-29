package com.qxb.leetcode._127;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qxb on 2016/11/29.
 */
public class Solution1 {

    //Leetcode solution, the two way switch is quite ingenious, but why the three level for is acceptable? efficient than me?
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

    public static void main(String[] args){
        Solution1 so = new Solution1();

        String beginWord = "hit";
        String endWord = "cog";
        Set<String> set = new HashSet<String>();

        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");


        System.out.println(so.ladderLength(beginWord, endWord, set));


        String beginWord1 = "hot";
        String endWord1 = "dot";
        Set<String> set1 = new HashSet<String>();

        set1.add("hot");
        set1.add("dot");
        set1.add("dog");
        System.out.println(so.ladderLength(beginWord1, endWord1, set1));

        String beginWord2 = "a";
        String endWord2 = "c";
        Set<String> set2 = new HashSet<String>();

        set2.add("a");
        set2.add("b");
        set2.add("c");
        System.out.println(so.ladderLength(beginWord2, endWord2, set2));
    }
}
