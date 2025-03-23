class Pair{
    long first; int second;
    Pair(long f, int s){
        first = f;
        second = s;
    }
}
class Solution {
    public int countPaths(int n, int[][] ar) {
        long dist[] = new long[n];
        int ways[] = new int[n];
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int i=0;i<ar.length;i++){
            adj.get(ar[i][0]).add(new Pair(ar[i][2], ar[i][1]));
            adj.get(ar[i][1]).add(new Pair(ar[i][2], ar[i][0]));
        }

        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.first));

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair temp =pq.poll();
            long d = temp.first;
            int node = temp.second;
            
           
           if(d>dist[node])continue;

           for(Pair it:adj.get(node)){
            int adjNode = it.second;
            long edgW = it.first;

            if(d+edgW < dist[adjNode]){
                dist[adjNode] = d+edgW;
                pq.add(new Pair(dist[adjNode],adjNode));
                ways[adjNode] = ways[node];
            }else if(d+edgW == dist[adjNode])
            ways[adjNode] = (ways[node]+ways[adjNode])%1000000007;
           } 
        }
        return ways[n-1]%1000000007;
    }
}