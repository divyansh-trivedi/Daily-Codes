class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.get(triangle.size()-1).size();
        int dp[][] = new int[n][n];

        for(int i = 0;i< n;i++)dp[n-1][i] = triangle.get(n-1).get(i);

        for(int i = n-2;i>=0;i--){
            for(int j = 0;j<=i;j++){
                int down = dp[i+1][j] + triangle.get(i).get(j);
                int diagonal = dp[i+1][j+1] + triangle.get(i).get(j);

                dp[i][j] = Math.min(down , diagonal);
            }
        }
        return dp[0][0];
    }
}