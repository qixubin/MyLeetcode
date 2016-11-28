package com.qxb.leetcode.tc.dp;

/**
 * Created by qixubin on 2016/6/4.

 Problem Statement

 The old song declares "Go ahead and hate your neighbor", and the residents of Onetinville have taken those words to heart.
 Every resident hates his next-door neighbors on both sides.
 Nobody is willing to live farther away from the town's well than his neighbors, so the town has been arranged in a big circle around the well.
 Unfortunately, the town's well is in disrepair and needs to be restored. You have been hired to collect donations for the Save Our Well fund.

 Each of the town's residents is willing to donate a certain amount, as specified in the int[] donations, which is listed in clockwise order around the well.
 However, nobody is willing to contribute to a fund to which his neighbor has also contributed.
 Next-door neighbors are always listed consecutively in donations, except that the first and last entries in donations are also for next-door neighbors.
 You must calculate and return the maximum amount of donations that can be collected.


 Definition

 Class:	BadNeighbors
 Method:	maxDonations
 Parameters:	int[]
 Returns:	int
 Method signature:	int maxDonations(int[] donations)
 (be sure your method is public)


 Constraints
 -	donations contains between 2 and 40 elements, inclusive.
 -	Each element in donations is between 1 and 1000, inclusive.

 */
public class BadNeighbors {

    public static int maxDonations(int[] donations){
        int max = 0;
        int len = donations.length;
        if (len ==1)
            return donations[0];

        if(len ==2)
            return Math.max(donations[0], donations[1]);

        if(len ==3){
            max = Math.max(Math.max(donations[0],donations[1]), donations[2]);
            return max;
        }

        int[] maxDon = new int[len];
        maxDon[0] = donations[0];
        maxDon[1] = donations[1];
        maxDon[2] = donations[2]+ donations[0];

        boolean[] hasfirst = new boolean[len];
        hasfirst[0] = true;
        hasfirst[2] = true;

        for(int i =3; i< len; i++){

            int prev2;
            int prev3;

            if (i == len-1){
//                System.out.println("aaa");
                if( hasfirst[i-2]){
                    prev2 = maxDon[i-2] + (donations[i] > donations[0] ? donations[i]-donations[0]: 0);
                }else{
                    prev2 = maxDon[i-2] +donations[i];
                }

                if( hasfirst[i-3]){
                    prev3 = maxDon[i-3] + (donations[i] > donations[0] ? donations[i]-donations[0]: 0);
                }else{
                    prev3 = maxDon[i-3] +donations[i];
                }

                maxDon[i] = Math.max(prev2, prev3);



            }else{
                prev2 = maxDon[i-2];
                prev3 = maxDon[i-3];
                if (prev2 > prev3){
                    maxDon[i] = donations[i] + prev2;
                    hasfirst[i] = hasfirst[i-2];
                }else if (prev2 == prev3){
                    maxDon[i] = donations[i] + prev2;
                    //hasfirst[i] = false;
                }else{
                    maxDon[i] = donations[i] + prev3;
                    hasfirst[i] = hasfirst[i-3];
                }

            }

            max = maxDon[i]>max? maxDon[i]:max;
        }

        return max;
    }


    public static void main(String[] argv){
        int[] nums0 = { 10, 3, 2, 5, 7, 8 }; //19
        int[] nums1 = { 11, 15 };// 15
        int[] nums2 = { 7, 7, 7, 7, 7, 7, 7 }; //21
        int[] nums3 = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };  //16
        int[] nums4 = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72}; //2926

        int[] nums5 ={162, 964, 975, 847, 31, 472, 61, 903, 713, 392, 798, 937, 378, 994, 969, 310, 924,
                766, 529, 422, 786, 844, 746, 428, 332, 832, 280, 233, 609, 744, 165, 635, 335, 655, 414, 661, 686, 374, 739, 599};//13227

        int[] nums6 = 	{349, 187, 672, 268, 750, 926, 787, 578, 784, 795, 991, 9, 416, 981,
                355, 840, 850, 501, 53, 794, 712, 740, 833, 113, 401, 285, 952, 422, 535, 532, 102};//10170

        int[] nums7 = 	{90, 1, 2, 89, 3, 4, 88, 5, 6, 87, 5, 4, 86, 3, 2, 85, 1, 2};//525

        System.out.println(maxDonations(nums0));
        System.out.println(maxDonations(nums1));
        System.out.println(maxDonations(nums2));
        System.out.println(maxDonations(nums3));
        System.out.println(maxDonations(nums4));
        System.out.println(maxDonations(nums5));
        System.out.println(maxDonations(nums6));
        System.out.println(maxDonations(nums7));


        }
}
