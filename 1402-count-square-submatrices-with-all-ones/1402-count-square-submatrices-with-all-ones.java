class Solution {
    public int countSquares(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int size = 1; size <= Math.min(n, m); size++) {
            sum += isPossible(matrix, size);
        }
        return sum;
    }

    private int isPossible(int[][] matrix, int len) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for (int i = 0; i + len <= n; i++) {
            for (int j = 0; j + len <= m; j++) {
                boolean ok = true;
                for (int dx = 0; dx < len && ok; dx++) {
                    for (int dy = 0; dy < len; dy++) {
                        if (matrix[i + dx][j + dy] == 0) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok) count++;
            }
        }
        return count;
    }
}
