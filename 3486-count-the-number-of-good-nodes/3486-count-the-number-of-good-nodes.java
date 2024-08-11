class Solution {
    
    private int helper(List<List<Integer>> adj, int[] subT, int currN, int parN){
        int size=1;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(var ad:adj.get(currN)){
            if(ad==parN){
                continue;
            }
            
            int newHelper = helper(adj, subT, ad, currN);
            size += newHelper;
            map.put(newHelper, map.getOrDefault(newHelper, 0)+1);
        }
        
        if(map.size()<=1){
            res++;
        }
        
        subT[currN]=size;
        return size;
    }
    
    int res=0;
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int[] subT = new int[n];
        
        helper(adj, subT, 0, -1);
        return res;
    }
}