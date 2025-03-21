class Disjoint {
    List<Integer> size = new ArrayList<>(), parent = new ArrayList<>();

    public Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            size.add(1);
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
    public int removeStones(int[][] stones) {
        int n= stones.length;
        int row = 0 , col = 0;
        for(int[] i: stones){
            row = Math.max(row, i[0]);
            col = Math.max(col , i[1]);
        }
        Disjoint ds = new Disjoint(row+col+2);

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + row + 1;

            ds.unionBySize(nodeRow, nodeCol);

            map.put(nodeRow,1);
            map.put(nodeCol,1);
        }

        int cnt = 0;
        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            int key = it.getKey();
            if(ds.findParent(key) == key)cnt++;
        }
        return n - cnt;
    }
}