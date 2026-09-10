class Solution {

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int[] dfs(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);

        // Get information from right subtree
        int[] right = dfs(node.right);

        // Current subtree ka sum
        int sum = node.val + left[0] + right[0];

        // Current subtree mein total nodes
        int count = 1 + left[1] + right[1];

        // Integer division automatically floor karega
        int average = sum / count;

        // Check
        if (node.val == average) {
            ans++;
        }

        // Current subtree ki information parent ko return karo
        return new int[]{sum, count};
    }
}