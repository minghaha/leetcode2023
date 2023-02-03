//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);
        reutrn max;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        max = Math.max(max, leftMaxDepth + rightMaxDepth);
        return Math.max(rightMaxDepth, leftMaxDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
