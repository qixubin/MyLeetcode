package com.qxb.leetcode._71;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by hacker on 7/5/2016.

 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"

 click to show corner cases.
 Corner Cases:

 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".

 */
public class Solution {

    public String simplifyPath(String path) {

//        StringTokenizer st = new StringTokenizer(path, "/");
        ArrayList<String> st = tokenise(path, "/");
        ArrayList<String> li = new ArrayList<String>();
        for(String s: st){

            if (s.equals(".")){

            }else if(s.equals("..")){
                if (li.size() >0)
                    li.remove(li.size()-1);
            }else{
                li.add(s);
            }
        }

        if (li.size() ==0) return "/";

        String res = "";

        for(String s: li){
            res = res + "/";
            res = res +s;
        }

        return res;
    }

    public ArrayList<String> tokenise(String s, String delim){
        ArrayList<String> res  = new ArrayList<String>();

        while(s.contains("/")){
            int index = s.indexOf("/");
            if(index ==0){
                s= s.substring(1);
            }else{
                res.add(s.substring(0,index));
                s = s.substring(index);
            }
        }

        if(s.length() >0)
            res.add(s);
        return res;
    }

    public static void main(String[] argv){

        Solution so = new Solution();
        System.out.println(so.simplifyPath("/home"));
        System.out.println(so.simplifyPath("/a/./b/../..//c/"));
        System.out.println(so.simplifyPath(""));
    }
}
