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
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);
        int extra =0;
        for (int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];

            int ulp_u =ds.findParent(u);
            int ulp_v =ds.findParent(v);

            if (ulp_u == ulp_v)extra++;
            else ds.unionBySize(u,v);
        }
        int cntC =0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i) == i)cntC++;
        }
        if(extra >= cntC -1)return cntC-1;
        return -1;
    }
}