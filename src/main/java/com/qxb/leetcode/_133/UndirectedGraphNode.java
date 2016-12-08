package com.qxb.leetcode._133;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qxb on 2016/12/7.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
