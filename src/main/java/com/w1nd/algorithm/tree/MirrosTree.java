package com.w1nd.algorithm.tree;

/**
 * 101. 对称二叉树：递归结束调节很重要，同时为空才返回true，不同时有一个为空一个不为则返回false，同时不为空才进行下面判断
 */
public class MirrosTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return dfs(root.left, root.right);
        }

        public boolean dfs(TreeNode p, TreeNode q) {
            if (p == null || q == null) return p == null && q == null;

            return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
        }
    }
}
