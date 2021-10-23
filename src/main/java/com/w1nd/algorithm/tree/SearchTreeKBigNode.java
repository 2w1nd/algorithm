package com.w1nd.algorithm.tree;

public class SearchTreeKBigNode {

     // * Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {
        int res, count;
        public int kthLargest(TreeNode root, int k) {
            count = k;
            dfs(root);
            return res;
        }

        public void dfs(TreeNode root) {
            if (root == null || count == 0) return ;
            dfs(root.right);
            if (--count == 0) {
                res = root.val;
                return ;
            }
            dfs(root.left);
        }
    }
}
