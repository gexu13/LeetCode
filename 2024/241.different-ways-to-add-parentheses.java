/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        char[] e = expression.toCharArray();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftList = new ArrayList<>();
                List<Integer> rightList = new ArrayList<>();

                leftList = diffWaysToCompute(expression.substring(0, i));
                rightList = diffWaysToCompute(expression.substring(i + 1));

                for (int j : leftList) {
                    for (int k : rightList) {
                        if (c == '+') {
                            result.add(j + k);
                        } else if (c == '-') {
                            result.add(j - k);
                        } else {
                            result.add(j * k);
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.valueOf(expression));
            return result;
        }
        return result;
    }
}
// @lc code=end

