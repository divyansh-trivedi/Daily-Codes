/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    

class Solution {
       

        // public void check(Node root){
        //     if(root==null)
        //     return ;

        //     check(root.left);
        //     check(root.right);
        //     ar.add(root.val);
        // }
    public List<Integer> postorder(Node root) {
         List<Integer> ar= new ArrayList<>();
    if(root==null)return ar;
for(Node  n:root.children){
    ar.addAll(postorder(  n));

}
ar.add(root.val);
        return ar;
    }
}