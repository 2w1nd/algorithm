package com.w1nd.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合：暴搜，时间复杂度 4 ^ n * n
 */
public class LetterCombinationsofaPhoneNumber {
    class Solution {

        List<String> res;
        String strs[] = {
                "", "", "abc", "def",
                "ghi","jkl","mno",
                "pqrs","tuv","wxyz",
        };

        public List<String> letterCombinations(String digits) {
            res = new ArrayList();
            if (digits == null || digits.length() == 0) return new ArrayList<>();
            dfs(digits, 0, "");
            return res;
        }

        public void dfs(String digits, int u, String path) {
            if (u == digits.length()) res.add(path);
            else {
                String tmp = strs[digits.charAt(u) - '0'];
                for (int i = 0; i < tmp.length(); i ++) {
                    dfs(digits, u + 1, path + tmp.charAt(i));
                }
            }
        }
    }
}
