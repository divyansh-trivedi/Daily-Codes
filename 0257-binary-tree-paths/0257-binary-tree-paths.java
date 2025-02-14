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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String s ="";
        dfs(list,root , s);
        return list;
    }
    public void dfs(List<String> list, TreeNode root , String s){
        if(root == null)return ;
        if(root.left == null && root.right ==null)
        list.add(s+root.val);

        dfs(list , root.left , s+root.val+"->");
        
        dfs(list , root.right , s+root.val+"->");

    }
}