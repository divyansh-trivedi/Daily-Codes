class Solution {
    public int[] findOrder(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new  ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        
        for(int i[]:edges)adj.get(i[1]).add(i[0]);
         
        int indeg[] =new int[n];
        
        for(int i=0;i<n;i++){
            for(int it: adj.get(i))
            indeg[it]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;i++)
            if(indeg[i] == 0)q.add(i);
            
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            int el = q.peek();
            q.poll();
            list.add(el);
            for(int i:adj.get(el)){ 
                indeg[i] --; 
                if(indeg[i] == 0)q.add(i);
            }
        }
        if(list.size() != n) return new int[]{};

        int ar[] = new int[n];
        for(int i=0;i<n;i++)
        ar[i] =  list.get(i);
        
        return ar;
    }
}