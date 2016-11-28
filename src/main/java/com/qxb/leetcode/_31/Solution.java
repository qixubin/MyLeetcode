package com.qxb.leetcode._31;

/**
 * Created by qixubin on 2016/5/23.
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 */
public class Solution {

    public void nextPermutation(int[] nums) {
        int len =nums.length;

        if (len ==1)
            return;

        int i = len -1;
//        int minIndex = nums.length-1;
//        int minValue = Integer.MIN_VALUE;
        for (; i>0 ; i--){
            if (nums[i] <= nums[i-1]){

            }else{
                break;
            }
        }

        if (i >0){
            int z= nums[i-1];

            for ( int n = i; n <len ; n ++){

                if (nums[n] <=z){
                    swap(nums, i-1, n-1);
                    break;
                }

                if (n ==len -1){
                    swap(nums,i-1,n);
                }
            }
        }

        quickSort(nums, i, len-1);


    }

    public void swap(int[] nums, int i, int j){
        int k = nums[i];
        nums[i]= nums[j];
        nums[j] =k;
    }

    int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    public static void main(String[] argc){

        Solution s1 = new Solution();
        //int[] nums =new int[] {1,2,3};

//        int[] nums =new int[] {3,2,1};
        int[] nums =new int[] {1,5,1};
        s1.nextPermutation(nums);
        printArr(nums);
    }

    public static void printArr(int[] nums){
        for (int i =0;i< nums.length ; i++){
            System.out.print(nums[i]+ " ");
        }
        System.out.println();
    }
}
