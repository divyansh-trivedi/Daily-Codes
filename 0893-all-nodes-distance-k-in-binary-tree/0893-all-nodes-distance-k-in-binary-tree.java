
class Solution {
    static List<Integer> list ;
    static HashMap<TreeNode , TreeNode > map;

    public void solve1(TreeNode root){
        if(root == null)return;

        if(root.right != null)map.put(root.right,root); 
        if(root.left != null)map.put(root.left,root);

        solve1(root.left);
        solve1(root.right); 
    }

    public void solve(TreeNode target, int k){
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        q.add(target);
        set.add(target);
        int level =-1;
        while(!q.isEmpty()){
            level++;
            if(level == k){
                while(!q.isEmpty())
                list.add(q.poll().val);
                return;
            }
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode r = q.poll();
                if(map.containsKey(r) && !set.contains(map.get(r)) ){
                    q.add(map.get(r));
                    set.add(map.get(r));
                }
                if(r.left != null && !set.contains(r.left)){
                q.add(r.left);
                set.add(r.left);
                }
                 if(r.right != null && !set.contains(r.right)){
                q.add(r.right);
                set.add(r.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        list = new ArrayList<>(); 
        map = new HashMap<>();
        solve1(root);
        solve(target,k);
        return list;
    }
}