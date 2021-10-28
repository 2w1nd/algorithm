package com.w1nd.algorithm.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class YangHui {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> pre = new ArrayList<Integer>();
            List<Integer> one = new ArrayList<Integer>();

            int in = 0;
            one.add(1);
            pre.add(1);
            res.add(one);

            for (int i = 1; i < numRows; i ++) {
                List<Integer> now = new ArrayList<Integer>();
                for (int j = 0; j <= i; j ++) {
                    if (j == 0 || j == i) {
                        in = pre.get(0);
                    } else {
                        in = pre.get(j - 1) + pre.get(j);
                    }
                    now.add(in);
                }
                res.add(now);
                pre.add(0);
                Collections.copy(pre, now);
            }
            return res;
        }
    }
}
