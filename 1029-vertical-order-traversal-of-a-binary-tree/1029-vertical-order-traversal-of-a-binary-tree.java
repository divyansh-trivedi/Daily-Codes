class Tuple{
    TreeNode node;
    int row, col;
    Tuple(TreeNode n , int r, int c){
        node = n;
        row = r;
        col = c;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map  = new TreeMap<>();//{row = verticle , col = level , node.data}
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));//{node, verrticle ,level}

        while(!q.isEmpty()){
            Tuple t = q.poll();// { n , x, y}-> x = verticle || ->y = level
            TreeNode n = t.node;
            int x = t.row ,y = t.col;

            map.putIfAbsent(x,new TreeMap<>());
            map.get(x).putIfAbsent(y,new PriorityQueue<>());
            map.get(x).get(y).add(n.val);

            if(n.left != null)q.offer(new Tuple(n.left,x-1,y+1));
            if(n.right != null)q.offer(new Tuple(n.right,x+1,y+1));
        }
        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> it1: map.values()){
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> it2 : it1.values()){
                while(!it2.isEmpty())
                    temp.add(it2.poll());
            }
            ans.add(temp);
        }
        return ans;

    }
}