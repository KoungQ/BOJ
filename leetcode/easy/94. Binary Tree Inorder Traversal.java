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
    List<Integer> answer;

    public List<Integer> inorderTraversal(TreeNode root) {
        answer = new ArrayList<>();
        dfs(root, 0, 999);
        return answer;
    }

    void dfs(TreeNode here, int left, int right) {
        if(here == null)
            return;
        
        dfs(here.left, left, right);
        answer.add(here.val);
        dfs(here.right, left, right);
    }
}