package com.qxb.leetcode._30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qixubin on 2016/5/23.
 */
public class Solution1 {


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int sLen          = s.length();
        int wNum          = words.length;
        if (sLen == 0 || wNum == 0 || words[0].length() == 0) {
            return res;
        }

        int wLen = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        int[] counts = new int[wNum];

        //Mapping words to integer IDs and count the occurrences of each unique word int the given word array
        for (int i = 0; i < wNum; i ++) {
            Integer id = map.get(words[i]);
            if (id == null) {
                id = map.size();
                map.put(words[i], id);
            }
            counts[id] ++;
        }

        int mNum = sLen - wLen + 1;
        List<List<Integer>> matchLists = new ArrayList<List<Integer>>();
        for (int i = 0; i < wLen; i ++) {
            matchLists.add(new ArrayList<Integer>());
        }

        //scan the s string and convert the string into wLen different ID lists
        for (int i = 0; i < mNum; i ++) {
            matchLists.get(i%wLen).add(map.get(s.substring(i, i + wLen)));
        }

        //scan each ID list with a wNum-long window and see whether a window has all the words in given words array
        for (int offset = 0; offset < wLen; offset ++) {
            List<Integer> list = matchLists.get(offset);
            int[] cMap = new int[wNum];
            int pos = -1;
            for (int begin = 0, end = wNum - 1; end < list.size(); begin ++, end ++) {

                //expire the invalid IDs
                if (pos < begin) {
                    pos = begin;
                }

                while (pos <= end) {
                    Integer id = list.get(pos);

                    // it means a unknown word found or a word having too many occurrences in the window
                    if (id == null || cMap[id] == counts[id]) {
                        break;
                    }
                    cMap[id] ++;
                    pos ++;
                }

                // means the window have all the words
                if (pos == end + 1) {
                    res.add(offset + begin * wLen);
                }

                //remove the count of the word at the old position
                Integer oldId = list.get(begin);
                if (oldId != null) {
                    cMap[oldId] --;
                }
            }
        }

        return res;
    }

    public static void main(String[] argv){
        Solution1 s1= new Solution1();
        String s = "barfoothefoobarman";
        String[] a = new String[2];
        a[0]="foo";
        a[1]="bar";
        List<Integer> result = s1.findSubstring(s, a);
        System.out.println(result.size());
    }
}
