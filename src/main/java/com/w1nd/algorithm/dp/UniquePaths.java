package com.w1nd.algorithm.dp;

import java.util.Arrays;

/**
 * 62. 不同路径：路径dp
 */
public class UniquePaths {

    // 2维
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[110][110];
            for (int i = 0; i < m; i ++)
                for (int j = 0; j < n; j ++)
                {
                    if (i == 0 && j == 0) dp[i][j] = 1;
                    else {
                        if (i != 0) dp[i][j] += dp[i - 1][j];
                        if (j != 0) dp[i][j] += dp[i][j - 1];
                    }
                }
            return dp[m - 1][n - 1];
        }
    }

    // 1维
    class Solution1 {
        public int uniquePaths(int m, int n) {
            int[] cur = new int[n];
            Arrays.fill(cur, 1);
            for (int i = 1; i < m; i ++)
                for (int j = 1; j < n; j ++)
                    cur[j] += cur[j - 1];
            return cur[n - 1];
        }
    }
}
