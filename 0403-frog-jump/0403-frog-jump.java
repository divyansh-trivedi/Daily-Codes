import java.util.*;

class Solution {
    public static boolean solve(int dp[][], int[] stones, Map<Integer, Integer> map, int curr_stone_idx,
            int prev_jump) {
        if (curr_stone_idx == stones.length - 1)
            return true;

        if (prev_jump < 0 || prev_jump >= dp[0].length)
            return false;

        if (dp[curr_stone_idx][prev_jump] != -1)
            return dp[curr_stone_idx][prev_jump] == 1;

        boolean flag = false;
        for (int i = prev_jump - 1; i <= prev_jump + 1; i++) {

            if (i > 0) {
                int new_jump = stones[curr_stone_idx] + i;
                if (map.containsKey(new_jump))
                    flag = flag || solve(dp, stones, map, map.get(new_jump), i);
            }
        }
        dp[curr_stone_idx][prev_jump] = (flag ? 1 : 0);
        return flag;
    }

    public static boolean canCross(int[] stones) {
        int dp[][] = new int[2001][2001];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++)
            map.put(stones[i], i);
        if (stones.length <= 1 || stones[1] != 1)
            return false;
        return solve(dp, stones, map, 0, 0);
    }

 
}