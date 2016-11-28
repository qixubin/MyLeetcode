package com.qxb.leetcode.tc.dp;

/**
 * Created by qixubin on 2016/6/4.
 Problem Statement

 You are planting a flower garden with bulbs to give you joyous flowers throughout the year.
 However, you wish to plant the flowers such that they do not block other flowers while they are visible.

 You will be given a int[] height, a int[] bloom, and a int[] wilt.
 Each type of flower is represented by the element at the same index of height, bloom, and wilt. height represents how high each type of flower grows,
 bloom represents the morning that each type of flower springs from the ground, and wilt represents the evening that each type of flower shrivels up and dies.

 Each element in bloom and wilt will be a number between 1 and 365 inclusive, and wilt[i] will always be greater than bloom[i].
 You must plant all of the flowers of the same type in a single row for appearance, and you also want to have the tallest flowers as far forward as possible.
 However, if a flower type is taller than another type, and both types can be out of the ground at the same time,
 the shorter flower must be planted in front of the taller flower to prevent blocking.

 A flower blooms in the morning, and wilts in the evening, so even if one flower is blooming on the same day another flower is wilting, one can block the other.

 You should return a int[] which contains the elements of height in the order you should plant your flowers to achieve the above goals.
 The front of the garden is represented by the first element in your return value, and is where you view the garden from.
 The elements of height will all be unique, so there will always be a well-defined ordering.


 Definition

 Class:	FlowerGarden
 Method:	getOrdering
 Parameters:	int[], int[], int[]
 Returns:	int[]
 Method signature:	int[] getOrdering(int[] height, int[] bloom, int[] wilt)
 (be sure your method is public)


 Constraints
 -	height will have between 2 and 50 elements, inclusive.
 -	bloom will have the same number of elements as height
 -	wilt will have the same number of elements as height
 -	height will have no repeated elements.
 -	Each element of height will be between 1 and 1000, inclusive.
 -	Each element of bloom will be between 1 and 365, inclusive.
 -	Each element of wilt will be between 1 and 365, inclusive.
 -	For each element i of bloom and wilt, wilt[i] will be greater than bloom[i].


 */
public class FlowerGarden {
    // 06/04 finished sorted height. to do.... sorted three array according to the first one' index
    public int[] getOrdering(int[] height, int[] bloom, int[] wilt){
        int len = height.length;
        if (len ==1)
            return height;

        Node top = null;
        Node current = null;
        Node previous = null;

        for (int i = 0 ; i< len; i ++){
            previous = null;
            if (top ==null) {
                top = new Node(i);
                top.next = null;
                continue;
            }

            current = top;
            while(current!=null){
                Node new_node = new Node(i);
                if (overlap(current.index,i, bloom, wilt)){

                    if (previous!=null){
                        new_node.next = current;
                        previous.next = new_node;
                    }else{
                        top = new_node;
                        new_node.next = current;
                    }
                    break;
                }else{
                    if (current.next ==null){
                        current.next = new_node;
                        break;
                    }
                }
                previous = current;
                current = current.next;
            }
        }

        int[] result = new int[len];
        int k =0;
        while(top !=null){
            result[k++] = height[top.index];
            top = top.next;
        }
//            Node new_node = new Node(i);
//            current.next = new_node;
        return result;
    }

    public boolean overlap(int i, int j,int[] bloom, int[] wilt) {
        int b_i = bloom[i];
        int w_i= wilt[i];
        int b_j = bloom[j];
        int w_j = wilt[j];
        if (b_j> w_i || b_i > w_j)
            return false;

        return true;
    }

    class Node{
        int index;
        Node next;
        public Node(int i){
            this.index = i;
        }
    }

    public static void main(String[] argv){
        FlowerGarden fg = new FlowerGarden();
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

        int[] h1 ={1,2,3,4,5,6};
        int[] b1 ={1,3,1,3,1,3};
        int[] w1 ={2,4,2,4,2,4};


        int[] o1 = fg.getOrdering(h1,b1,w1);

        for(int i =0; i < o1.length;i++){
            System.out.print(o1[i] +",");
        }
    }
}
