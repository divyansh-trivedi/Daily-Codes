class Solution {
    public int minimumEffortPath(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        int n = grid.length;
        int m= grid[0].length;
        int dist[][] = new int[n][m];

        pq.add(new int[]{0,0,0});

        for(int i[] : dist)Arrays.fill(i, (int)1e9);
        dist[0][0] = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1 , 0, -1};
        int min= (int)1e9;
        while(!pq.isEmpty()){
            int ar[] = pq.poll();
            int diff = ar[0];
            int r = ar[1];
            int c = ar[2];

            if(r == n -1 && c == m-1)
                    return diff;
           
            for(int k=0;k<4;k++){
                int newr = r+ dr[k];
                int newc = c+ dc[k];
                if(newr>=0&& newc>=0 && newr<n && newc<m ){
                    int newEffort = Math.max(Math.abs(grid[r][c] - grid[newr][newc]), diff);
                    if(newEffort < dist[newr][newc]){
                        dist[newr][newc] = newEffort;
                        pq.add(new int[]{ newEffort, newr, newc});
                    }                  
                }
            }
        }
        return -1;
    }
}