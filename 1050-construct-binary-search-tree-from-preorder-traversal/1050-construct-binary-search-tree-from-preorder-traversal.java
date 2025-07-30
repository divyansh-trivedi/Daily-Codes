class Solution {
    private int i = 0; 
    private TreeNode solve(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) return null;

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = solve(preorder, root.val);
        root.right = solve(preorder, bound);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder, Integer.MAX_VALUE);
    }
}
