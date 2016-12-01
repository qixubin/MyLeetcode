package com.qxb.leetcode._126;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 * <p>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * <p>
 * Created by qxb on 2016/11/29.
 */
public class Solution {
    Map<String, List<String>> map;
    List<List<String>> results;


    //leetcode solution
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        results = new ArrayList<List<String>>();
        if (dict.size() == 0)
            return results;

        int min = Integer.MAX_VALUE;

        Queue<String> queue = new ArrayDeque<String>();
        queue.add(start);

        map = new HashMap<String, List<String>>();

        Map<String, Integer> ladder = new HashMap<String, Integer>();
        for (String string : dict)
            ladder.put(string, Integer.MAX_VALUE);
        ladder.put(start, 0);

        dict.add(end);
        //BFS: Dijisktra search
        while (!queue.isEmpty()) {

            String word = queue.poll();

            int step = ladder.get(word) + 1;//'step' indicates how many steps are needed to travel to one word.

            if (step > min) break;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String new_word = builder.toString();
                    if (ladder.containsKey(new_word)) {

                        if (step > ladder.get(new_word))//Check if it is the shortest path to one word.
                            continue;
                        else if (step < ladder.get(new_word)) {
                            queue.add(new_word);
                            ladder.put(new_word, step);
                        } else ;// It is a KEY line. If one word already appeared in one ladder,
                        // Do not insert the same word inside the queue twice. Otherwise it gets TLE.

                        if (map.containsKey(new_word)) //Build adjacent Graph
                            map.get(new_word).add(word);
                        else {
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            map.put(new_word, list);
                            //It is possible to write three lines in one:
                            //map.put(new_word,new LinkedList<String>(Arrays.asList(new String[]{word})));
                            //Which one is better?
                        }

                        if (new_word.equals(end))
                            min = step;

                    }//End if dict contains new_word
                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
        }//End While

        //BackTracking
        LinkedList<String> result = new LinkedList<String>();
        backTrace(end, start, result);

        return results;
    }

    private void backTrace(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null)
            for (String s : map.get(word))
                backTrace(s, start, list);
        list.remove(0);
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


        so.results = so.findLadders(beginWord, endWord, set);
        System.out.println(so.results.size());


        String beginWord1 = "hot";
        String endWord1 = "dot";
        Set<String> set1 = new HashSet<String>();

        set1.add("hot");
        set1.add("dot");
        set1.add("dog");
        so.findLadders(beginWord1, endWord1, set1);

        String beginWord2 = "a";
        String endWord2 = "c";
        Set<String> set2 = new HashSet<String>();

        set2.add("a");
        set2.add("b");
        set2.add("c");
        so.findLadders(beginWord2, endWord2, set2);

    }
}
