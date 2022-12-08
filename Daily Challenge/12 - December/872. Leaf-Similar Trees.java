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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;

        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();

        treeTraversal(root1, leafs1);
        treeTraversal(root2, leafs2);

        return leafs1.equals(leafs2); // compare two lists of primitive types for equality is using the List.equals() method. 
      // It returns true if both lists have the same size, and all corresponding pairs of elements in both lists are equal.
    }

    public void treeTraversal(TreeNode root, List<Integer> leafs) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                leafs.add(root.val);
                return;
            }

            treeTraversal(root.left, leafs);
            treeTraversal(root.right, leafs);
        }
    }
}
