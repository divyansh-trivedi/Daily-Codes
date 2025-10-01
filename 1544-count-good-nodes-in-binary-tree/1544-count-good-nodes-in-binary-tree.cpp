class Solution {
    int sum = 0;
private:
    void solve(TreeNode* root,int ele) {
        if (root == NULL) return;
        if (root->val >= ele) sum++;
        ele = max(ele, root->val);

        solve(root->left,ele);
        solve(root->right,ele);
    }
public:
    int goodNodes(TreeNode* root) {
        if (root == NULL) return 0;
        solve(root, root->val);
        return sum;
    }
};
