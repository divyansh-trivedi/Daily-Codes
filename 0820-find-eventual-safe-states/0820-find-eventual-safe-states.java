class Solution {
    public boolean dfs(int pathVis[],int node , int vis[], ArrayList<ArrayList<Integer>> adj, int check[]){
                vis[node] =1;
                pathVis[node] =1;
                check[node] =0;
        
                for(int i: adj.get(node)){
                    if(vis[i] == 0){
                        if(dfs(pathVis, i, vis, adj, check)==true)return true;
                    }else if (pathVis[i] == 1) return true;
                }
                check[node] = 1;
                pathVis[node] = 0;
                return false;
            }
        
          
            public List<Integer> safeNodes( ArrayList<ArrayList<Integer>> adj) {
               int v = adj.size();
               int vis[] = new int[v];
               int pathVis[] = new int[v];
               int check[] = new int[v];
               List<Integer> list = new ArrayList<>();
        
               for (int i = 0; i < v; i++) {
                if (vis[i] == 0) 
                    dfs(pathVis, i, vis, adj, check);
               }
        
               for(int i=0;i<v;i++){
                if(check[i] == 1)list.add(i);
               }
               return list;
            }
        
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) 
        list.add(new ArrayList<>()); 

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++)
                list.get(i).add(graph[i][j]);
        }
        return safeNodes(list);
    }
    
}