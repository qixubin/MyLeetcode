package com.qxb.leetcode._127;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * <p>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * <p>
 * <p>
 * Created by qxb on 2016/11/29.
 */
public class Solution {

    //my solution time limit exceeded
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        int len = wordList.size();

        String[] words = new String[len];
        wordList.toArray(words);

        Set<String> currLevel = new HashSet<String>();
        currLevel.add(beginWord);
        Set<String> nextLevel = new HashSet<String>();

        int[] range = new int[len];
        int result = 2;
        boolean haveCurr = true;

        while (haveCurr) {
            if (canTrans(endWord, currLevel)) {
                if (result ==2){
                    return 0;
                }
                return result;
            } else {
                haveCurr = false;
                for (String c : currLevel) {
                    for (int i = 0; i < words.length; i++) {
                        if (range[i] != 0) continue;

                        String s = words[i];
                        if (canTrans(s, c)) {
                            nextLevel.add(s);
                            range[i] = result - 1;
                            haveCurr = true;
                        }
                    }
                }
                currLevel = nextLevel;
                nextLevel = new HashSet<String>();
                result++;
            }
        }
        return 0;
    }

    public boolean canTrans(String word1, Set<String> list) {
        for (String s : list) {
            if (canTrans(word1, s)) {
                return true;
            }
        }
        return false;
    }

    public boolean canTrans(String word1, String word2) {
        if (word1.equals(word2)) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }


    public static void main(String[] args) {

        Solution so = new Solution();

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


        System.out.println(so.canTrans("lot","dog"));
        System.out.println(so.canTrans("lot","log"));
        System.out.println(so.canTrans("a","c"));
    }
}
