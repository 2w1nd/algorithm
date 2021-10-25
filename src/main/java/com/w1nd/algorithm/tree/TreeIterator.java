package com.w1nd.algorithm.tree;

import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器：栈模拟中序遍历
 */
public class TreeIterator {
     // * Definition for a binary tree node.
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

    class BSTIterator {

        Stack<TreeNode> stk = new Stack();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stk.add(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode p = stk.pop();
            int val = p.val;
            p = p.right;
            while (p != null) {
                stk.add(p);
                p = p.left;
            }
            return val;
        }

        public boolean hasNext() {
            return stk.size() > 0;
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
