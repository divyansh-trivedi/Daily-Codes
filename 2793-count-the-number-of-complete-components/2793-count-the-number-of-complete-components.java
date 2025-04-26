class Solution {
    public void dfs(int node,ArrayList<ArrayList<Integer>> list, boolean vis[],ArrayList<Integer> comp){
        vis[node] = true;
        comp.add(node);
        for(int i: list.get(node)){
            if(vis[i] == false)
            dfs(i, list, vis, comp);
        }
    }
    public int countCompleteComponents(int n, int[][] ar) {
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());

        for(int i=0;i<ar.length;i++){
            int u = ar[i][0];
            int v = ar[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean vis[] = new boolean[n];
        int cnt =0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ArrayList<Integer> comp = new ArrayList<>();
    
                dfs(i,list,vis, comp);
                int size = comp.size();
                boolean flag = true;
                for(int it: comp){
                    if(list.get(it).size()!=size-1){
                        flag = false;
                        break;
                    }
                }
                if(flag)cnt++;
            }
        }return cnt;
    }
}