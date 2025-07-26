
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        map<int, int> inmap;
        for(int i=0;i<inorder.size();i++)
        inmap[inorder[i]] = i;

        return solve(preorder , 0,preorder.size()-1,inorder,0,inorder.size()-1,inmap);
        
    }
private:
    TreeNode* solve(vector<int>& pre, int pres, int pree, 
                    vector<int>& in , int ins, int ine,
                     map<int, int>& inmap){

        if(ins>ine || pres>pree)
        return NULL;

        TreeNode* root = new TreeNode(pre[pres]);
        
        int inRoot = inmap[root->val];
        int numsLeft = inRoot - ins;

        root->left = solve(pre,pres+1,pres+numsLeft , in , ins,inRoot-1, inmap);
        root->right = solve(pre,pres+numsLeft+1,pree , in , inRoot+1,ine, inmap);

        return root;

    }
};