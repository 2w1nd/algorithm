package com.w1nd.algorithm.dp;

/**
 * 55. 跳跃游戏
 */
public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int maxPos = 0;
            for (int i = 0; i < nums.length; i ++) {
                if (maxPos < i) return false;
                maxPos = Math.max(maxPos, nums[i] + i);
            }
            return true;
        }
    }
}
