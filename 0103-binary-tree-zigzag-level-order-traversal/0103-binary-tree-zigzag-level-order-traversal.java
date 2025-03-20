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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();

        // list.get(0).add(new ArrayList<>());
        if(root == null)return ans;

        q.offer(root);
        int level= 0;
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            if(level%2!=0){
                ans.add(new ArrayList<>());
                for(int i= temp.size()-1;i>=0;i--)ans.get(level).add(temp.get(i));
            }
            else ans.add(temp);
            level++;
        }
        return ans;
    }
}