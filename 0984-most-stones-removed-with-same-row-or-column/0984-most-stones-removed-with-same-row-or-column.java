class Disjoint{
   List<Integer> size = new ArrayList<>();
   List<Integer> parent = new ArrayList<>();
   public Disjoint(int n){
    for(int i=0;i<=n;i++){
        size.add(0);
        parent.add(i);
     }
   }
   public int findParent(int node){
    if(node == parent.get(node))
    return node;

    int ultimate_parent = findParent(parent.get(node));
    parent.set(node, ultimate_parent);
    return parent.get(node);
   }

   public void unionBySize(int u, int v){
    int ultimate_parent_u = findParent(u);
    int ultimate_parent_v = findParent(v);

    if(ultimate_parent_u == ultimate_parent_v)return;

    if(size.get(ultimate_parent_u) > size.get(ultimate_parent_v)){
        parent.set(ultimate_parent_v,ultimate_parent_u);
        size.set(ultimate_parent_u, size.get(ultimate_parent_v)+size.get(ultimate_parent_u));   
    }else{
        parent.set(ultimate_parent_u, ultimate_parent_v);
        size.set(ultimate_parent_v,size.get(ultimate_parent_v)+size.get(ultimate_parent_u ));
    }
   }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxr = 0, maxc = 0;
        for(int it[]:stones){
            maxr = Math.max(maxr, it[0]);
            maxc = Math.max(maxc, it[1]);
        }
        Disjoint ds = new Disjoint(maxr + maxc+1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int it[] : stones){
            int r = it[0];
            int c = it[1] + maxr + 1;

            ds.unionBySize(r, c);
            map.put(r,1);
            map.put(c,1);
        }
        int cnt = 0;
        for(int it: map.keySet()){
            if(ds.findParent(it) == it)
            cnt++;
        }
        return n-cnt;
    }
}






















