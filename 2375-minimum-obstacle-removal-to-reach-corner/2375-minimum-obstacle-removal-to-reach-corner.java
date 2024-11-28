final class Solution {
    private int[][] dp, grid;
    private int nbRows, nbColumns;
    private Queue<int[]> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();
    private static final int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public final int minimumObstacles(final int[][] grid) {
        this.initializeMembers(grid);
        while (!this.queue1.isEmpty()) {
            final int[] cell = this.queue1.poll();
            this.populateQueue(cell[0], cell[1]);
            if (this.queue1.isEmpty())
                this.swapQueues();
        }
        return this.dp[this.nbRows - 1][this.nbColumns - 1];
    }

    private final void initializeMembers(final int[][] grid) {
        this.grid = grid;
        this.nbRows = this.grid.length;
        this.nbColumns = this.grid[0].length;
        this.dp = new int[this.nbRows][this.nbColumns];
        for (final int[] row : this.dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        this.dp[0][0] = 0;
        this.queue1.add(new int[]{0, 0});
    }

    private final void populateQueue(final int i, final int j) {
        for (int k = 0; k < 4; ++k) {
            final int x = i + Solution.dx[k], y = j + Solution.dy[k];
            if (x == -1 || x == this.nbRows || y == -1 || y == this.nbColumns || this.dp[x][y] != Integer.MAX_VALUE)
                continue;
            final int isObstacle = grid[x][y];
            this.dp[x][y] = this.dp[i][j] + isObstacle;
            if (isObstacle == 1)
                this.queue2.add(new int[]{x, y});
            else
                this.queue1.add(new int[]{x, y});
        }
    }

    private final void swapQueues() {
        final Queue<int[]> temporary = this.queue1;
        this.queue1 = this.queue2;
        this.queue2 = temporary;
    }
}