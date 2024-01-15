/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            result += checkPalindromic(sArray, i, i);
            result += checkPalindromic(sArray, i, i + 1);
        }
        return result;
    }

    private int checkPalindromic(char[] sArray, int head1, int head2) {
        int count = 0;
        while (head1 >= 0 && head2 < sArray.length) {
            if (sArray[head1] == sArray[head2]) {
                count++;
                head1--;
                head2++;
            } else {
                break;
            }
        }
        return count;
    }
}
// @lc code=end

