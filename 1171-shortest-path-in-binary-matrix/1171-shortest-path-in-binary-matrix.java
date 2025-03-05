import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while (!q.isEmpty()) {
            int[] ar = q.poll();
            int r = ar[0], c = ar[1], dist = ar[2];

            if (r == n - 1 && c == m - 1) return dist;

            for (int k = 0; k < 8; k++) {
                int newr = r + dr[k];
                int newc = c + dc[k];

                if (newr >= 0 && newc >= 0 && newr < n && newc < m && grid[newr][newc] == 0) {
                    grid[newr][newc] = 1;
                    q.add(new int[]{newr, newc, dist + 1});
                }
            }
        }
        return -1;
    }
}
