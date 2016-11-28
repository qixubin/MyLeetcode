package com.qxb.leetcode._93;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hacker on 7/26/2016.
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * For example:
 * Given "25525511135",
 * <p>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();

        helper(s, new ArrayList<String>(), res);

        return res;
    }

    public void helper(String s, List<String> li, List<String> res) {
        int li_size = li.size();

        if (s.length() > ((4 - li_size) * 3) || s.length() < (4 - li_size)) {
            return;
        }

        if (li.size() == 4) {
            if (s.length() == 0) {
                StringBuffer ip = new StringBuffer();
                int count = 0;
                for (String sli : li) {
                    ip.append(sli);

                    if (count++ < 3)
                        ip.append(".");
                }

                res.add(ip.toString());
            } else {
                return;
            }

        } else {
            if (li.size() == 3) {
                int m = Integer.valueOf(s);
                if (s.length() != new Integer(m).toString().length())  return;
                if (m <= 255) {
                    List<String> li_copy = new ArrayList<String>(li);
                    li_copy.add(s);

                    helper("", li_copy, res);
                }else{
                    return;
                }
            } else {

                for (int i = 1; i <= 3 && i <= s.length(); i++) {
                    String si = s.substring(0, i);
                    String left = s.substring(i);


                    int m = Integer.valueOf(si);
                    if (si.length() != new Integer(m).toString().length()) return;
                    if (m <= 255) {
                        List<String> li_copy = new ArrayList<String>(li);
                        li_copy.add(si);

                        helper(left, li_copy, res);
                    } else {
                        return;
                    }
                }
            }
        }


    }

    public static void main(String[] args) {
        //        int k = Integer.valueOf("-1.0");
//
//        System.out.println(k);

//        System.out.println("a".substring(1).length());
        Solution so = new Solution();
        String s = "0000";

        List<String> res = so.restoreIpAddresses(s);
        System.out.println(res.size());


    }

}
