class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        int n = grid.length;
        int m = grid[0].length;
         if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

        int dist[][]= new int[n][m];
        int dx[] = {-1,-1,-1,0,0,1,1,1};
        int dy[] = {-1,0,1,1,-1,-1,0,1};

        for(int i[]: dist)Arrays.fill(i,(int)1e9);
        dist[0][0] = 1;

        while(!q.isEmpty()){
            int ar[] = q.poll();
            int r = ar[0];
            int c = ar[1];

            if(r==n-1&& c==m-1)return dist[r][c];

            for(int i=0;i<8;i++){
                int newR = dx[i]+r;
                int newC = dy[i]+c;

                if(newR>=0&& newC>=0 && newR<n && newC<m && grid[newR][newC] == 0&& dist[newR][newC] > 1+dist[r][c]){
                    dist[newR][newC] = 1+dist[r][c];
                    q.add(new int[]{ newR, newC});
                }
            }
        }
        return -1;
    }
}