/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp
        // subsequence不连续
        int[] dp = new int[nums.length];
        int result = 1;
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;

        // O(nlogn) binary search
    //     List<Integer> list = new ArrayList<>();
    //     list.add(nums[0]);

    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] > list.get(list.size() - 1)) {
    //             list.add(nums[i]);
    //         } else {
    //             int index = binarySearch(list, nums[i]);
    //             list.set(index, nums[i]);
    //         }
    //     }
    //     return list.size();
    // }

    // private int binarySearch(List<Integer> list, int target) {
    //     int left = 0;
    //     int right = list.size() - 1;
    //     int mid = 0;

    //     while (left < right) {
    //         mid = left + (right - left) / 2;
    //         if (list.get(mid) >= target) {
    //             right = mid;
    //         } else {
    //             left = mid + 1;
    //         }
    //     }
    //     return right;
    }
}
// @lc code=end

