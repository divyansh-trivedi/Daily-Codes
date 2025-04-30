class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int n= graph.length;
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        ArrayList<Integer> topo = new ArrayList<>();
        int outd[] = new int[n];
        
        for(int i=0;i<n;i++)reverseGraph.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            for(int it :graph[i])
                reverseGraph.get(it).add(i);
            outd[i] = graph[i].length;
            if(outd[i] == 0)
            q.add(i);
        }

        while(!q.isEmpty()){
            int rem = q.poll();
            topo.add(rem);

            for(int it:reverseGraph.get(rem)){
                outd[it]--;
                if(outd[it] == 0)
                q.add(it);
            }
        }
        Collections.sort(topo);
        return topo;
    }
}