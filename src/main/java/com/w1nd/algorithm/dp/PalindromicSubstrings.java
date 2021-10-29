package com.w1nd.algorithm.dp;

/**
 * 647. 回文子串：扩张中心点法（熟记）
 */
public class PalindromicSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            int ans = 0;
            int len = s.length();

            for (int center = 0; center < 2 * len - 1; center ++) {
                int left = center / 2;
                int right = left + center % 2;
                while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                    left --;
                    right ++;
                    ans ++;
                }
            }
            return ans;
        }
    }
}
