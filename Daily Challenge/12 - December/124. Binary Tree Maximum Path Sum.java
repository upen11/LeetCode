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
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        sumFromSubtree(root);
        return maxSum;
    }

    // post order traversal of subtree rooted at 'root'
    private int sumFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use 'Math.max' here.
        int leftMax = Math.max(sumFromSubtree(root.left), 0);

        // add the path sum from right subtree. 0 if negative
        int rightMax = Math.max(sumFromSubtree(root.right), 0);

        // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        // sum without splitting
        maxSum = Math.max(maxSum, leftMax + rightMax + root.val);

        // return the max sum for a path starting at the root of subtree
        // sum with splitting for longest path
        return Math.max(leftMax, rightMax) + root.val;
    }
}
