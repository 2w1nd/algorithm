package com.w1nd.algorithm.list;

import javax.swing.tree.TreeNode;

/**
 * 114. 二叉树展开为链表：先遍历左节点，再插入
 */
public class TreeToList {

     //Definition for a binary tree node.
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
        public void flatten(TreeNode root) {
            while (root != null) {
                TreeNode p = root.left;
                if (p != null) {
                    while (p.right != null) p = p.right;
                    p.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
        }
    }
}
