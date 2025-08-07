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
    int widthOfBinaryTree(TreeNode* root) {
         if(root == NULL)
        return 0;
        long long ans = 0;
        queue<pair<TreeNode*, long long>> q;
        q.push({root,0});
        
        while(!q.empty()){
            int size = q.size();
            int mini = q.front().second;
            long long first, last;
            for(int i=0;i<size;i++){
                TreeNode* r = q.front().first;
                long long id = q.front().second - mini;
                q.pop();

                if(i == 0)first = id;
                if(i == size-1)last = id;

                if(r->left != NULL)q.push({r->left , id*2+1});
                if(r->right != NULL)q.push({r->right , id*2+2});
            }
            ans = max(ans,last-first+1);
        }
        
        return (int)ans;
    }
};