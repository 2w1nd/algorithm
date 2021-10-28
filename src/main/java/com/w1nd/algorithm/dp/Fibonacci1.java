package com.w1nd.algorithm.dp;

public class Fibonacci1 {
    class Solution {
        public int fib(int n) {
            int[] dp = new int[n + 1];
            if (n == 0 || n == 1) return n == 0 ? 0: 1;
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i ++) dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            return dp[n];
        }
    }
    class Solution1 {
        int numWays(int n) {
            int a = 1, b = 1, sum;
            for(int i = 0; i < n; i ++) {
                sum = (a + b) % 1000000007;
                a = b;
                b = sum;
            }
            return a;
        }
    }
}
