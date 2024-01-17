/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        int result = nums[0];
        min[0] = nums[0];
        max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i], Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]));
            max[i] = Math.max(nums[i], Math.max(min[i - 1] * nums[i], max[i - 1] * nums[i]));
            if (max[i] > result) {
                result = max[i];
            }
        }
        return result;
    }
}
// @lc code=end

