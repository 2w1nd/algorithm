package com.w1nd.algorithm.tree;

/**
 * 剑指 Offer 26. 树的子结构：两次递归（对每个结点的遍历+判断是否正确的遍历）
 */
public class TreeSonStruct {

    // Definition for a binary tree node.
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;
            if (isPart(A, B)) return true;
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        public boolean isPart(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null || A.val != B.val) return false;
            return isPart(A.left, B.left) && isPart(A.right, B.right);
        }
    }
}
