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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjoint ds = new Disjoint (n*n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0)continue;
                int dr[] = {-1,0,1,0};
                int dc[] ={0,1,0,-1};

                for(int k=0;k<4;k++){
                    int newr = i + dr[k];
                    int newc = j + dc[k];

                    if(newr>=0&&newc>=0&&newr<n&&newc<n  && grid[newr][newc] == 1){
                        int nodeNo = i*n + j;
                        int newNodeNo = newr*n + newc;

                        ds.unionBySize(nodeNo , newNodeNo);
                    }
                }
            }
        }

        int max = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) continue;
                Set<Integer> components = new HashSet<>();

                int dr[] = {-1,0,1,0};
                int dc[] ={0,1,0,-1};

                for(int k=0;k<4;k++){
                    int newr = i+dr[k];
                    int newc = j + dc[k];

                    if(newr>=0&&newc>=0&&newr<n&&newc<n ){
                        if(grid[newr][newc] == 1)
                        components.add(ds.findParent(newr*n+newc));
                    }
                }
                int total_size = 0;
                
                for(Integer it : components){
                    total_size += ds.size.get(it);
                }
                max = Math.max(max, total_size + 1);
            }
        }
        for(int i=0;i<n*n;i++){
            max= Math.max(max, ds.size.get(ds.findParent(i)));
        }
        return max;
    }
}