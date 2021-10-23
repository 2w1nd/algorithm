package com.w1nd.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II：使用队列
 */
public class TopToBottomPrintTree2 {
     // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (q.size() > 0) {
                List<Integer> tmp = new ArrayList<>();
                for (int i = q.size(); i > 0; i --) {
                    TreeNode node = q.poll();
                    tmp.add(node.val);
                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }
                res.add(tmp);
            }
            return res;
        }
    }
}
