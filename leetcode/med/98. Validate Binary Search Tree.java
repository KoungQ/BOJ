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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean dfs(TreeNode here, long leftVal, long rightVal) {
        if (here == null)
            return true;

        if (here.val <= leftVal || here.val >= rightVal) {
            return false;
        }

        return dfs(here.left, leftVal, here.val) && 
                    dfs(here.right, here.val, rightVal);
    }
}