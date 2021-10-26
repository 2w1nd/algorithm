package com.w1nd.algorithm.tree;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III：加个flag实现反转
 */
public class TopToBottomPrintTree3 {

    // Definition for a binary tree node.
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList();
            if (root == null) return res;
            Queue<TreeNode> q = new LinkedList();
            q.add(root);
            boolean flag = false;
            while (q.size() > 0) {
                List<Integer> tmp = new ArrayList();
                for (int i = q.size(); i > 0; i --) {
                    TreeNode p = q.poll();
                    tmp.add(p.val);
                    if (p.left != null) q.add(p.left);
                    if (p.right != null) q.add(p.right);
                }
                if (flag) Collections.reverse(tmp);
                flag = !flag;
                res.add(tmp);
            }
            return res;
        }
    }
}
