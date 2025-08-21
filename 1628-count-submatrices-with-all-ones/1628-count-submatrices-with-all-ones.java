class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] num = new int[n];
        int total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) num[j] += 1;
                else num[j] = 0;
            }

          
            for (int j = 0; j < n; j++) {
                int minH =num[j];
                for (int k = j; k >= 0 && minH > 0; k--) {
                    minH = Math.min(minH, num[k]);
                    total += minH;
                }
            }
        }
        return total;
    }
}