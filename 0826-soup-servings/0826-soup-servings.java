class Solution {
    private Double[][] memo;

    public double soupServings(int n) {
        int N = (n + 24) / 25;
        if (N >= 200) return 1.0;
        memo = new Double[N + 5][N + 5];
        return dfs(N, N);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] != null) return memo[a][b];

        double prob = 0.0;
        prob += 0.25 * dfs(Math.max(0, a - 4), b);
        prob += 0.25 * dfs(Math.max(0, a - 3), Math.max(0, b - 1));
        prob += 0.25 * dfs(Math.max(0, a - 2), Math.max(0, b - 2));
        prob += 0.25 * dfs(Math.max(0, a - 1), Math.max(0, b - 3));

        memo[a][b] = prob;
        return prob;
    }
}