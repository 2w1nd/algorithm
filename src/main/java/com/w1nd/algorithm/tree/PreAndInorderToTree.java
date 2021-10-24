package com.w1nd.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树 !!!!!
 */
public class PreAndInorderToTree {

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

    class Solution {
        Map<Integer, Integer> hash = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i ++) hash.put(inorder[i], i);
            return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
            if (pl > pr) return null;

            int val = preorder[pl];
            int k = hash.get(val); //前序数字在中序中的位置
            int len = k - il; // 左子树长度
            TreeNode root = new TreeNode(val);
            root.left = dfs(preorder, inorder, pl + 1, pl + len, il, k - 1);
            root.right = dfs(preorder, inorder, pl + len + 1, pr, k + 1, ir);
            return root;
        }
    }
}
