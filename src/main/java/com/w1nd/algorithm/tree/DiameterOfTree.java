package com.w1nd.algorithm.tree;

/**
 * 543. 二叉树的直径
 */
public class DiameterOfTree {

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

        int res = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);

            return res;
        }

        public int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            int rigth = dfs(root.right);
            res = Math.max(res, left + rigth);
            return Math.max(left + 1, rigth + 1);
        }
    }
}
