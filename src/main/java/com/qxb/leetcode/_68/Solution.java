package com.qxb.leetcode._68;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hacker on 7/2/2016.

 Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:

 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]

 Note: Each word is guaranteed not to exceed L in length.

 click to show corner cases.
 Corner Cases:

 A line other than the last line might contain only one word. What should you do in this case?
 In this case, that line should be left-justified.

 */
public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> li = new ArrayList<String>();

        int startIndex =0;
        int endIndex =0;
        boolean first= true;
        int currentLen =0;
        for (int i =0; i < words.length; i++){
            String word = words[i];
            if (first){

                currentLen = word.length();

                first = false;
                endIndex ++;
                continue;
            }

            if ( currentLen + 1 + word.length() <= maxWidth){

                currentLen = currentLen+ 1+word.length();
                endIndex++;
                continue;
            }else{
                String re=just(words, startIndex, endIndex, currentLen, maxWidth);

                li.add(re);

                startIndex =i;

                currentLen = word.length();
                endIndex = i+1;
            }


        }

        String re=just(words, startIndex, endIndex, currentLen ,maxWidth);

        li.add(re);
        return li;
    }

    public String just(String[] words, int startIndex, int endIndex, int currentLen,int maxWidth){
        String sb= new String("");
        int count = endIndex - startIndex;

        if(endIndex == words.length){

            for(int i =0; i< count; i++){
                sb +=words[startIndex + i];
                if  (i <count -1){
                    sb += " ";
                }
            }


            while(sb.length() < maxWidth){
                sb += " ";
            }
            return sb;
        }


        int spaceCount = maxWidth - currentLen +count -1;
        String[] spaces = divideSpaces(spaceCount, count -1);

        for(int i =0; i< count; i++){
            sb +=words[startIndex + i];
            sb +=spaces[i];
        }

        return sb.toString();
    }
    public String[] divideSpaces(int spaceCount, int count){
        String[] res = new String[count+1];

        if (count ==0){
            res[0] = nSpace(spaceCount);
            return res;
        }

        int quot = spaceCount/count;
        int rem = spaceCount%count;

        for(int i = 0; i< rem; i++){
            res[i] = nSpace(quot+1);
        }

        for(int i = rem; i< count; i++){
            res[i] = nSpace(quot);
        }

        res[count] = "";

        return res;
    }

    public String nSpace(int n){
        String res = "";
        for(int i =0 ; i<n ;i++){
            res += " ";
        }
        return res;

    }

    public static void main(String[] argv){
        Solution so = new Solution();
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        List<String> re = so.fullJustify(words,16);

//        String[] words = {"What","must","be","shall","be."};
//        List<String> re = so.fullJustify(words,12);

        String[] words = {""};
        List<String> re = so.fullJustify(words,0);

        for( String s:re ){
            System.out.println(s);
        }

    }
}
