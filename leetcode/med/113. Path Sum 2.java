class Solution {
    List<List<Integer>> answer;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        answer = new ArrayList<>();
        if (root == null)
            return answer;

        dfs(new ArrayList<>(), root, targetSum, 0);
        return answer;
    }

    void dfs(List<Integer> path, TreeNode here, int targetSum, int sum) {
        sum += here.val;
        path.add(here.val);

        // 리프 노드일 때 합 검사
        if (here.left == null && here.right == null) {
            if (sum == targetSum) {
                answer.add(new ArrayList<>(path));
            }
        } else {
            if (here.left != null) {
                dfs(path, here.left, targetSum, sum);
            }
            if (here.right != null) {
                dfs(path, here.right, targetSum, sum);
            }
        }

        path.remove(path.size() - 1);
    }
}