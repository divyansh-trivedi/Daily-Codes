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
    int count (TreeNode root){
        if(root==null)return 0;
        
        return 1+count(root.left)+count(root.right);
    }
    
    boolean isCBT(TreeNode root , int idx, int count){
        if(root==null)return true;
        
        if(idx>=count)return false;
        
        return isCBT(root.left ,2*idx+1 ,count) && isCBT(root.right ,2*idx+2 ,count) ;
        
    
    }
    public boolean isCompleteTree(TreeNode root) {
         int idx=0;
        int countNodes = count(root);
        return isCBT(root , idx , countNodes);
        
    }
}