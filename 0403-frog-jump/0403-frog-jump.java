class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    Boolean[][] dp;

    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        dp = new Boolean[n][n + 1];
        return solve(stones, 0, 0);
    }
    public boolean solve(int[] stones, int i, int lastJump) {
        if (i == stones.length - 1) 
            return true;

        if (dp[i][lastJump] != null)
            return dp[i][lastJump];

        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            if (jump > 0) {
                int nextPos = stones[i] + jump;
                if (map.containsKey(nextPos)) {
                    int nextIndex = map.get(nextPos);

                    if (solve(stones, nextIndex, jump)) {
                        return dp[i][lastJump] = true;
                    }
                }
            }
        }
        return dp[i][lastJump] = false;
    }
}