package com.w1nd.algorithm.dp;

/**
 * 64. 最小路径和
 */
public class MinimumPathSum {
    // 2维
    class Solution {
        public int minPathSum(int[][] grid) {
            int n = grid.length, m = grid[0].length;
            int[][] dp = new int[210][210];
            for (int i = 0; i < n; i ++)
                for (int j = 0; j < m; j ++) {
                    if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                    else {
                        dp[i][j] = 0x3f3f3f3f;
                        if (i != 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                        if (j != 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i][j]);
                    }
                }
            return dp[n - 1][m - 1];
        }
    }

    // 1维
    class Solution1 {
        public int minPathSum(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[] dp = new int[210];
            dp[0] = grid[0][0];

            for (int i = 1; i < m; i ++)
                dp[i] = dp[i - 1] + grid[0][i];
            for (int i = 1; i < n; i ++) {
                dp[0] = dp[0] + grid[i][0];
                for (int j = 1; j < m; j ++) {
                    dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
                }
            }

            return dp[m - 1];
        }
    }
}
