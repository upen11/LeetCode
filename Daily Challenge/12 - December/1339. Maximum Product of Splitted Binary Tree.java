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
    long totalSum = 0, ans = 0;
    
    public int maxProduct(TreeNode root) {
        totalSum = traversal(root); // find the total sum
        traversal(root); // this time we will calculate ans using the above totalSum.

        ans %= 1_000_000_000 + 7;

        return (int)ans;
    }

    public long traversal(TreeNode root) {
        if (root == null) return 0;

        // totalSum
        long left = traversal(root.left);
        long right = traversal(root.right);
        long currSum = root.val + left + right;

        //product of splitted BT, Part1=totalSum-currSum, Part2=currSum.
        ans = Math.max(ans, (totalSum - currSum) * currSum);

        return currSum;
    }
}
