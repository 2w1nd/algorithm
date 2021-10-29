package com.w1nd.algorithm.dp;

/**
 *5. 最长回文子串：扩展中心法
 */
public class LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            int len = s.length();

            for (int center = 0; center < 2 * len - 1; center ++) {
                int left = center / 2;
                int rigth = left + center % 2;
                while (left >= 0 && rigth < len && s.charAt(left) == s.charAt(rigth)) {
                    if (res.length() < rigth - left + 1) {
                        res = s.substring(left, rigth + 1);
                    }
                    left --;
                    rigth ++;
                }
            }
            return res;
        }
    }
}
