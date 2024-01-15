/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            // 找到了交换的位置
            if (nums[i] > nums[i - 1]) {
                int index = search(nums, i, nums[i - 1]);
                swap(nums, i - 1, index);
                reverse(nums, i, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int start, int target) {
        int ans = start;
        for (int i = nums.length - 1; i >= start; i--) {
            if (target < nums[i]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
// @lc code=end

