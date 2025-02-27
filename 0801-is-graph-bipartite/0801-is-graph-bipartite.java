class Solution {
    public boolean bfs(int vis[], int start , int [][] graph){
        Queue<Integer> q= new LinkedList<>();
        vis[start] = 0;
        q.add(start);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : graph[node]){
                if(vis[it] == -1){
                    vis[it] = vis[node] == 1 ? 0 : 1;
                    q.add(it);
                }else if(vis[it] == vis[node])return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int vis[] = new int[graph.length];
        Arrays.fill(vis,-1);

        for(int i=0;i<vis.length;i++){
            if(vis[i] == -1)
                if(!bfs(vis, i , graph))return false;
        }
        return true;
    }
}