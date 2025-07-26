class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    int arr[] = new int[102];

    public void add(TreeNode root) {
        if (root == null) return;

        list.add(root.val);
        add(root.left);
        add(root.right);
    }

    public void solve(TreeNode root) {
        if (root == null) return;

        root.val = arr[root.val];
        solve(root.left);
        solve(root.right);
    }

    public TreeNode bstToGst(TreeNode root) {
        list.clear();  // Clear static list to avoid stale values
        add(root);

        // Fill arr with values from the list
        for (int i = 0; i < list.size(); i++) {
            arr[list.get(i)] = list.get(i);
        }

        // Build suffix sum (Greater Tree requirement)
        for (int i = 100; i >= 0; i--) {
            if (i + 1 < 102)
                arr[i] += arr[i + 1];
        }

        solve(root);
        return root;
    }
}
