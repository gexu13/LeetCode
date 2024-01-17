/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int minJump = 0;
        int maxRange = 0;
        int curRange = 0;
        
        for (int i = 0; i <= curRange; i++) {
            maxRange = Math.max(maxRange, i + nums[i]);
            if (maxRange >= nums.length - 1) {
                return ++minJump;
            }
            if (i == curRange) {
                minJump++;
                curRange = maxRange;
            }
        }
        return minJump;
    }
}
// @lc code=end

