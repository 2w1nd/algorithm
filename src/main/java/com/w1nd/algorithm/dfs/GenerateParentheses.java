package com.w1nd.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成：dfs
 * n是括号对数，lc是左括号数量，rc是右括号数量，str是当前维护的合法括号序列。
 * 1、初始时定义序列的左括号数量lc 和右括号数量rc都为0。
 * 2、如果 lc < n，左括号的个数小于n，则在当前序列str后拼接左括号。
 * 3、如果 rc < n && lc > rc , 右括号的个数小于左括号的个数，则在当前序列str后拼接右括号。
 * 4、当lc == n && rc == n 时，将当前合法序列str加入答案数组res中。
 */
public class GenerateParentheses {
    class Solution {

        List<String> res = new ArrayList();

        public List<String> generateParenthesis(int n) {
            dfs(n, 0, 0, "");
            return res;
        }

        public void dfs(int n, int lc, int rc, String path) {
            if (lc == n && rc == n) res.add(path);
            else {
                if (lc < n) dfs(n, lc + 1, rc, path + "(");
                if (rc < n && lc > rc) dfs(n, lc, rc + 1, path + ")");
            }
        }
    }
}
