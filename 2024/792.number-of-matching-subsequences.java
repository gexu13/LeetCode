/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    // TLE
    // Map<String, Integer> map = new HashMap<>();
    // public int numMatchingSubseq(String s, String[] words) {
    //     char[] sArray = s.toCharArray();
    //     int count = 0;

    //     for (String word : words) {
    //         if (map.containsKey(word)) {
    //             count++;
    //             continue;
    //         }
    //         if (helper(sArray, word.toCharArray())) {
    //             map.put(word, 1);
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    // private boolean helper(char[] s, char[] word) {
    //     int[][] dp = new int[s.length + 1][word.length + 1];
    //     for (int i = 0; i <= s.length; i++) {
    //         dp[i][0] = 1;
    //     }
    //     for (int i = 1; i <= s.length; i++) {
    //         for (int j = 1; j <= word.length; j++) {
    //             if (s[i - 1] == word[j - 1]) {
    //                 dp[i][j] = dp[i - 1][j - 1] | dp[i - 1][j];
    //             } else {
    //                 dp[i][j] = dp[i - 1][j];
    //             }
    //         }
    //     }
    //     return dp[s.length][word.length] == 1;
    // }
    
    // Brute Force + HashSet
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Set<String> set = new HashSet<>();
        char[] sArray = s.toCharArray();
        for (String word : words) {
            if (set.contains(word)) {
                count++;
                continue;
            }
            if (helper(sArray, word.toCharArray())) {
                set.add(word);
                count++;
            }
        }
        return count;
    }

    private boolean helper(char[] sArray, char[] wordArray) {
        int start = 0;
        boolean found = false;

        for (Character c : wordArray) {
            found = false;
            for (int i = start; i < sArray.length; i++) {
                if (sArray[i] == c) {
                    found = true;
                    start= i + 1;
                    break;
                }
            }
            if (found == false) return false;
        }
        return true;
    }
}
// @lc code=end

