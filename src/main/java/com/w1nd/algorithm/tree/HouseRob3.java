package com.w1nd.algorithm.tree;

/**
 * 337. 打家劫舍 III：树上dp：0代表不偷，1代表偷
 */
public class HouseRob3 {

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
        public int rob(TreeNode root) {
            int[] res = new int[2];
            res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        public int[] dfs(TreeNode root) {
            if (root == null) {
                int[] n = new int[2];
                return n;
            }
            int[] res = new int[2];

            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 看两个儿子偷或不偷的最大数量
            res[1] = root.val + left[0] + right[0]; // 看儿子不偷与自己偷的最大数量
            return res;
        }
    }
}
