package com.w1nd.algorithm.tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列：1. 分治
 */
public class SortedTreeBackBianli {
    class Solution {

        int[] seq;

        public boolean verifyPostorder(int[] postorder) {
            seq = postorder;
            return dfs(0, seq.length - 1);
        }

        public boolean dfs(int l, int r) {
            if (l > r) return true;
            int root = seq[r];
            int k = l;
            while (k < r && seq[k] < root) k ++;
            for (int i = k; i < r; i ++)
                if (seq[i] < root) return false;
            return dfs(l, k - 1) && dfs(k, r - 1);
        }
    }
}
