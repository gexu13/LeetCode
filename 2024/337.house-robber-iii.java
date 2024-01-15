/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] dp = robHelper(root);

        return Math.max(dp[0], dp[1]);
    }

    private int[] robHelper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        // 左右中 后续遍历
        int[] left = robHelper(root.left);
        int [] right = robHelper(root.right);

        // rob root
        int robRoot = left[1] + right[1] + root.val;
        int notRobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{robRoot, notRobRoot}; 
    }
}
// @lc code=end

