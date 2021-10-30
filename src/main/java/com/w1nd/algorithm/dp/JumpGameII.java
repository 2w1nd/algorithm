package com.w1nd.algorithm.dp;

/**
 * 45. 跳跃游戏 II：dp+贪心
 */
public class JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            int end = 1;
            int start = 0;
            int ans = 0;
            while (end < nums.length) {
                int maxPos = 0;
                for (int i = start; i < end; i ++) maxPos = Math.max(maxPos, i + nums[i]);
                start = end;
                end = maxPos + 1;
                ans ++;
            }
            return ans;
        }
    }
}
