class Disjoint {
    List<Integer> size = new ArrayList<>(), parent = new ArrayList<>();
    public Disjoint(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(0);
            parent.add(i);
        }
    }
    public int findParent(int node) {
        if (node == parent.get(node)) return node;
        parent.set(node, findParent(parent.get(node)));
        return parent.get(node);
    }
    public void unionBySize(int u, int v) {
        int pu = findParent(u), pv = findParent(v);
        if (pu != pv) {
            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }
}
class Solution {
    public int findCircleNum(int[][] adj) {
        int V =adj.length;
        Disjoint ds =  new Disjoint(V);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj[i][j] == 1)
                ds.unionBySize(i,j);
            }
        }
        int cnt =0;
        for(int i=0;i<V;i++){
            if(ds.parent.get(i) == i)cnt++;
        }
        return cnt;
    }
}