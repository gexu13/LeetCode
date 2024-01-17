/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int jumpRange = 0;
        for (int i = 0; i <= jumpRange; i++) {
            jumpRange = Math.max(jumpRange, i + nums[i]);
            if (jumpRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

