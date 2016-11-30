package com.qxb.leetcode._126;

import java.util.*;

/**
 * Created by qxb on 2016/11/30.
 */
public class Solution1 {
    List<List<String>> results;
    List<String> list;
    Map<String,List<String>> map;
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        results= new ArrayList<List<String>>();
        if (dict.size() == 0)
            return results;

        int curr=1,next=0;
        boolean found=false;
        list = new LinkedList<String>();
        map = new HashMap<String,List<String>>();

        Queue<String> queue= new ArrayDeque<String>();
        Set<String> unvisited = new HashSet<String>(dict);
        Set<String> visited = new HashSet<String>();

        queue.add(start);
        unvisited.add(end);
        unvisited.remove(start);
        //BFS
        while (!queue.isEmpty()) {

            String word = queue.poll();
            curr--;
            for (int i = 0; i < word.length(); i++){
                StringBuilder builder = new StringBuilder(word);
                for (char ch='a';  ch <= 'z'; ch++){
                    builder.setCharAt(i,ch);
                    String new_word=builder.toString();
                    if (unvisited.contains(new_word)){
                        //Handle queue
                        if (visited.add(new_word)){//Key statement,Avoid Duplicate queue insertion
                            next++;
                            queue.add(new_word);
                        }

                        if (map.containsKey(new_word))//Build Adjacent Graph
                            map.get(new_word).add(word);
                        else{
                            List<String> l= new LinkedList<String>();
                            l.add(word);
                            map.put(new_word, l);
                        }

                        if (new_word.equals(end)&&!found) found=true;

                    }

                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
            if (curr==0){
                if (found) break;
                curr=next;
                next=0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }//End While

        backTrace(end,start);

        return results;
    }
    private void backTrace(String word,String start){
        if (word.equals(start)){
            list.add(0,start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if (map.get(word)!=null)
            for (String s:map.get(word))
                backTrace(s,start);
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
