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
    List<Integer> list = new ArrayList<>();
    public void inorder(TreeNode root){
        if(root == null)return;

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int q : queries){
           int idx = Collections.binarySearch(list,q);
           int floor =-1;
           int ceil =-1;
           if(idx >= 0){
            floor = list.get(idx);
            ceil = list.get(idx);
           }else{
            int i = -(idx) -1;
            if(i < list.size())
            ceil = list.get(i);
            if(i-1 >=0)floor =list.get(i-1);
           }

         List<Integer> temp = new ArrayList<>(); 
           temp.add(floor);
           temp.add(ceil);
           ans.add(temp);
        }
        return ans;
    }
}