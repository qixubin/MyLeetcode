package com.qxb.leetcode._60;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 7/1/2016.
 */
public class Solution1 {
    public String getPermutation(int n, int k) {
        if (k < 1) return "";
        int[] frac = new int[n + 1];
        frac[0] = 1;
        for (int i = 1; i <= n; i++) frac[i] = frac[i - 1] * i;
        if (frac[n] < k) return "";
        char[] nums = new char[n];
        for (int i = 0; i < n; i++) nums[i] = (char) (i + 1 + '0');
        for (int i = n; i >= 1; i--) {
            if (k == 1) break;
            else if (k == frac[i]) {
                for (int p = n - i, q = n - 1; p < q; p++, q--) {
                    char tmp = nums[p];
                    nums[p] = nums[q];
                    nums[q] = tmp;
                }
                break;
            } else if (k <= frac[i - 1]) continue;
            else {
                int p = k / frac[i - 1];
                if (k % frac[i - 1] > 0) p++;
                k -= frac[i - 1] * (p - 1);
                char tmp = nums[n - i];
                nums[n - i] = nums[n - i + p - 1];
                for (int q = n - i + p - 1; q > n - i + 1; q--)
                    nums[q] = nums[q - 1];
                nums[n - i + 1] = tmp;
            }
        }
        return String.valueOf(nums);
    }

    public static void main(String[] argv){
        Solution1 so1 = new Solution1();

        System.out.println(so1.getPermutation(8,8590));
    }
}
