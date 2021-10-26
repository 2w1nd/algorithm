package com.w1nd.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class TreeAndRoad {
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

        LinkedList<List<Integer>> res = new LinkedList();
        LinkedList<Integer> path = new LinkedList();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            dfs(root, target);
            return res;
        }

        public void dfs(TreeNode root, int sum) {
            if (root == null) return ;
            path.add(root.val);
            sum -= root.val;
            dfs(root.left, sum);
            dfs(root.right, sum);
            if (root.left == null && root.right == null && sum == 0) res.add(new LinkedList(path));
            path.removeLast();
        }
    }
}
