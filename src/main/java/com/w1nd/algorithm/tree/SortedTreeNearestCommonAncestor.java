package com.w1nd.algorithm.tree;

/**
 *剑指 Offer 68 - I. 二叉搜索树的最近公共祖先：两个结点在二叉搜索树一定一个比组先大，一个比祖先小
 */
public class SortedTreeNearestCommonAncestor {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
            if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
            return root;
        }
    }
}
