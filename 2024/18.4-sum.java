/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int left = 0;
        int right = 0;
        long sum = 0;

        for (int i = 0; i <= nums.length - 4; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j <= nums.length - 3; j++) {
                // 去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                left = j + 1;
                right = nums.length - 1;

                while (left < right) {
                    sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++;
                        right--;
                        // 去重
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

