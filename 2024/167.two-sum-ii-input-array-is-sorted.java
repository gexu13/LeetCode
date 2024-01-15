/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        int[] result = new int[2];

        while (left < right) {
            sum = numbers[left] + numbers[right]; 
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            } 
        }
        return result;
    }
}
// @lc code=end

