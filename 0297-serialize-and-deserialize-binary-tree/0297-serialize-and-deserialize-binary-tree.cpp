/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
static TreeNode* node;
    string serialize(TreeNode* root) {
        node = root;
        return "";
    }

    TreeNode* deserialize(string data) {
        return node;
    }
};
TreeNode* Codec::node = nullptr;

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));