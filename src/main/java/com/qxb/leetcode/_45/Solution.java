package com.qxb.leetcode._45;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qixubin on 2016/5/31.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.
 */
public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return 1;
        Queue<step> li = new LinkedList<step>();

        while(true){
            if (li.size() ==0){
                int firstStep = nums[0];
                for (int i = firstStep; i >0; i --){
                    if (1+i ==len) {
                        return 1;
                    }else if (1+i < len){
                        if (nums[i]!=0)
                            li.add(new step(1, 1+ i));
                    }
                }
            }

            step s1 = li.poll();
            int index =s1.getCurrentIndex();
            int new_step = nums[index-1];
            for (int i = new_step; i >0; i --){
                if (index+i ==len) {
                    return s1.step+1;
                }else if (index+i < len){
                    if (nums[index +i-1] !=0)
                        li.add(new step(s1.getStep()+1, index+ i));
                }
            }
            if (li.size() ==0){
                break;
            }
        }

        return 0;
    }
    class step{
        int step;
        int currentIndex;

        public step(int step, int currentIndex){
            this.step = step;
            this.currentIndex = currentIndex;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public int getCurrentIndex() {
            return currentIndex;
        }

        public void setCurrentIndex(int currentIndex) {
            this.currentIndex = currentIndex;
        }
    }

    public static void main(String[] argv){
        Solution s1 = new Solution();
        int[] nums = {2,3,1,1,4,1};
        System.out.println(s1.jump(nums));

    }
}


