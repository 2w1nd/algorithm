package com.w1nd.algorithm.two_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串：双指针+哈希表
 */
public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> hash = new HashMap();
            int res = 0;
            for (int i = 0, j = 0; i < s.length(); i ++) {
                hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
                while (hash.get(s.charAt(i)) > 1) {
                    hash.put(s.charAt(j), hash.get(s.charAt(j)) - 1);
                    j ++;
                }
                res = Math.max(res, i - j + 1);
            }
            return res;
        }
    }
}
