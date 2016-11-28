package com.qxb.leetcode.tc.dp;

import java.util.HashMap;

/**
 * Created by qixubin on 2016/6/6.
 */
public class FlowerGarden_TC {


    //java solution
    public int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
        long startTime=0;
        startTime = System.currentTimeMillis();
        int n = height.length;
        int[] svar = new int[n];
        boolean[] used = new boolean[n];
        for (int i=0; i<n; ++i) {
            int best = -1;
            int verdi = -1;
            ytre:
            for (int j=0; j<n; ++j) {
                if (used[j]) continue;
                if (height[j]<=verdi) continue;
                for (int k=0; k<n; ++k) {
                    if (used[k]) continue;
                    if (height[k]>=height[j]) continue;
                    if (bloom[k]<=wilt[j] && wilt[k]>=bloom[j]) continue ytre;
                }
                best = j;
                verdi = height[j];
            }
            used[best] = true;
            svar[i] = height[best];
        }

        System.out.println("Time consumption " + (System.currentTimeMillis()-startTime) + " ms.");
        return svar;
    }

    //c++ solution
//    vector <int> getOrdering(vector <int> height, vector <int> bloom, vector <int> wilt) {
//        int n = size(height);
//        vector<bool> done(n,false);
//        vector<int> res(n);
//        REP(i,n) {
//            int best = -1;
//            REP(j,n) if(!done[j]) {
//                bool ok = true;
//                REP(k,n) if(k!=j && !done[k] && height[k]<height[j] &&
//                        bloom[k]<=wilt[j] && wilt[k]>=bloom[j]) ok = false;
//                if(ok && (best==-1 || height[j]>height[best])) best=j;
//            }
//            res[i] = height[best];
//            done[best] = true;
//        }
//        return res;
//    }

    public static void main(String[] argv){
        FlowerGarden_TC fg = new FlowerGarden_TC();
//        int[] h1 = {5,4,3,2,1};
//        int[] b1 = {1,1,1,1,1};
//        int[] w1 = {365,365,365,365,365};


//        int[] h1 ={5,4,3,2,1};
//        int[] b1 ={1,5,10,15,20};
//        int[] w1 ={4,9,14,19,24};

//        int[] h1 ={5,4,3,2,1};
//        int[] b1 ={1,5,10,15,20};
//        int[] w1 ={5,10,15,20,25};

//        int[] h1 ={5,4,3,2,1};
//        int[] b1 ={1,5,10,15,20};
//        int[] w1 ={5,10,14,20,25};

        int[] h1 ={1,2,3,4,5,6,7};
        int[] b1 ={1,3,1,3,1,3,1};
        int[] w1 ={2,4,2,4,2,4,2};


        int[] o1 = fg.getOrdering(h1,b1,w1);

        for(int i =0; i < o1.length;i++){
            System.out.print(o1[i] +",");
        }
    }
}
