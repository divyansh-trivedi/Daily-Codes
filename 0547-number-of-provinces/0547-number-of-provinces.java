class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> list, boolean vis[]){
        vis[node] = true;
        for(int i: list.get(node)){
            if(vis[i] == false)
            dfs(i, list, vis);
        }
    }
    public int findCircleNum(int[][] ar) {
        int n= ar.length;
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        for(int i=1;i<=n;i++)
            list.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(ar[i][j]==1)
                list.get(i).add(j);
            }
        }

        boolean vis[] = new boolean[n];
        int cnt =0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,list,vis);
            }
        }return cnt;
    }
}