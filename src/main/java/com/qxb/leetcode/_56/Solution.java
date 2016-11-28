package com.qxb.leetcode._56;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hacker on 6/30/2016.

 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 */
public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1){
            return intervals;
        }

        ArrayList<SortableInteval> sli= new ArrayList<SortableInteval>();
        for(Interval in : intervals){
            sli.add(new SortableInteval(in));
        }

        sli.sort(new SortableInteval());

        ArrayList<Interval> result = new ArrayList<Interval>();

        int start = sli.get(0).start;
        int end = sli.get(0).end;

        for (int i =0; i < sli.size(); i++){
            SortableInteval si = sli.get(i);
            if (si.start > end){
                result.add(new Interval(start, end));
                start = si.start;
                end = si.end;
            }else{
                end = Math.max(end, si.end);
            }
        }

        result.add(new Interval(start, end));

        return result;
    }

    public static void main(String[] argv){
        Solution s1 = new Solution();

        ArrayList<Interval> li = new ArrayList<Interval>();
        li.add(new Interval(8,10));
        li.add(new Interval(15,18));
        li.add(new Interval(1,3));
        li.add(new Interval(2,6));


        List<Interval> result = s1.merge(li);

//        li.sort
        System.out.println("end");

    }
}

class SortableInteval implements Comparator<SortableInteval>{
    int start;
    int end;
    SortableInteval() { start = 0; end = 0; }
    SortableInteval(Interval iv) { start = iv.start; end = iv.end; }

    @Override
    public int compare(SortableInteval o1, SortableInteval o2) {
        if  (o1.start == o2.start){
            return o1.end-o2.end;
        }
        return o1.start- o2.start;
    }
}
