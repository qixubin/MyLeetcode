package com.qxb.leetcode._57;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hacker on 7/1/2016.

 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
//        if(intervals.size()== 1) {
//            res.add(intervals.get(0));
//            return res;
//        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });

        int new_start = newInterval.start;
        int new_end = newInterval.end;


        boolean merge_added = false;

        for(int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);

            if(merge_added){
                res.add(cur);
            }else{
                if (cur.start > new_end){
                    merge_added = true;
                    res.add(new Interval(new_start, new_end));
                    res.add(cur);
                }else if (  new_start >cur.end ){
                    res.add(cur);
                }else{
                    new_start = Math.min(cur.start, new_start);
                    new_end =Math.max(cur.end, new_end);
                }
            }
        }

        if (!merge_added){
            res.add(new Interval(new_start, new_end));
        }

        return res;
    }

    public static void main(String[] argv){
        Solution so = new Solution();

        ArrayList<Interval> li = new ArrayList<Interval>();
        li.add(new Interval(1,3));
        li.add(new Interval(6,9));

        List<Interval> res = so.insert(li, new Interval(2,5));


        ArrayList<Interval> li2 = new ArrayList<Interval>();
        li2.add(new Interval(1,2));
        li2.add(new Interval(3,5));
        li2.add(new Interval(6,7));
        li2.add(new Interval(8,10));
        li2.add(new Interval(12,16));

        List<Interval> res2 = so.insert(li2, new Interval(4,9));

        System.out.println("aaa");
    }

}
