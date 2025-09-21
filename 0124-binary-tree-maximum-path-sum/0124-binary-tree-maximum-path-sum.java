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
    int max = -(int)1e9;
    private int solve(TreeNode root){
        if(root == null)return 0;

        int left = Math.max(solve(root.left),0);
        int right = Math.max(solve(root.right),0);

        max = Math.max(left+right+root.val , max);
        return Math.max(left, right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return max;
    }
}