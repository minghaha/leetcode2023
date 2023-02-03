
//leetcode submit region begin(Prohibit modification and deletion)
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

    List<Integer> results   =   new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return results;
        }
        results.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
