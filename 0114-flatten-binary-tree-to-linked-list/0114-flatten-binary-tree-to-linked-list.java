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
    public void flatten(TreeNode root) {
        flattenTree(root, null);
    }
    private TreeNode flattenTree(TreeNode root, TreeNode next) {
        if (root == null) return next;
        next = flattenTree(root.right, next);

        next = flattenTree(root.left, next);
        root.right = next;
        root.left = null;

        return root;
    }
}