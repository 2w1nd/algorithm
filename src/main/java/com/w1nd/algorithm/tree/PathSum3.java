package com.w1nd.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和 III：树上前缀和
 */
public class PathSum3 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        int res;
        Map<Integer, Integer> hash = new HashMap();
        public int pathSum(TreeNode root, int targetSum) {
            hash.put(0, 1);
            dfs(root, targetSum, 0);
            return res;
        }

        public void dfs(TreeNode root, int sum , int cur) {
            if (root == null) return ;
            cur += root.val;
            if (hash.containsKey(cur - sum))
                res += hash.get(cur - sum);
            if (hash.containsKey(cur)) hash.put(cur, hash.get(cur) + 1);
            else hash.put(cur, 1);
            dfs(root.left, sum, cur);
            dfs(root.right, sum, cur);
            hash.put(cur, hash.get(cur) - 1);
        }
    }
}
