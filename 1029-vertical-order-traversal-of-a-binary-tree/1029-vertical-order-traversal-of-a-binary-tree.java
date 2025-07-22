class Tuple{
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode n, int r, int c){
        row = r;
        col = c;
        node = n;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q =new LinkedList<>();
        q.add(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            int x = t.row;
            int y = t.col;
            TreeNode n = t.node;
            
            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(n.val);

            if(n.left != null)
            q.offer(new Tuple(n.left ,x-1,y+1));
            if(n.right != null)
            q.offer(new Tuple(n.right ,x+1,y+1));

        }
            List<List<Integer>> list = new ArrayList<>();
            for(TreeMap<Integer,PriorityQueue<Integer>>  ys : map.values()){
                List<Integer> temp  = new ArrayList<>();
                for(PriorityQueue<Integer> nodes: ys.values()){
                    while(!nodes.isEmpty()){
                        temp.add(nodes.poll());
                    }
                }
                list.add(temp);
            }
            return list;
    }
}