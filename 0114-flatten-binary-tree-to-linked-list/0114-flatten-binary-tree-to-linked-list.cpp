/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void flatten(TreeNode* root) {
        if(root == NULL)return;
       stack<TreeNode*> st;
       st.push(root);

       while(!st.empty()){
        TreeNode* tp = st.top();
        st.pop();
        if(tp->right)st.push(tp->right);
        if(tp->left)st.push(tp->left);

        if(!st.empty())
            tp->right = st.top();

        tp->left = NULL;
       }

       return ;
    }
};