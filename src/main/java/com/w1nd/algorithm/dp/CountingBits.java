package com.w1nd.algorithm.dp;

/**
 * 338. 比特位计数：状态表示：以i为终点的1的个数
 *              状态转移：为奇数时，为上一个数加1
 *              为偶数时，为该数右移一位（除2）得到的数的1的个数
 */
public class CountingBits {
    class Solution {
        public int[] countBits(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for (int i = 1; i <= n; i ++) {
                if (i % 2 == 1) dp[i] = dp[i - 1] + 1;
                else dp[i] = dp[i / 2];
            }
            return dp;
        }
    }
}
