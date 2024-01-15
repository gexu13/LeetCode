/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // 三个指针
        // zeroIndex指针位置及其左边全都是0
        // twoIndex指针位置及其右边全都是2
        // oneIndex去遍历
        int zeroIndex = -1;
        int twoIndex = nums.length;
        int oneIndex = 0;
        int temp = 0;

        while (oneIndex < twoIndex) {
            if (nums[oneIndex] == 0) {
                zeroIndex++;
                temp = nums[zeroIndex];
                nums[zeroIndex] = nums[oneIndex];
                nums[oneIndex] = temp;
                oneIndex++;
            } else if (nums[oneIndex] == 1) {
                oneIndex++;
            } else {
                twoIndex--;
                temp = nums[twoIndex];
                nums[twoIndex] = nums[oneIndex];
                nums[oneIndex] = temp;
            }
        }
    }
}
// @lc code=end

