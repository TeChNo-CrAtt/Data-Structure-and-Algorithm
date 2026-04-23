class Solution {
    Integer[][] dp;
        public int lastStoneWeightII(int[] stones) {

        int total = 0;
        for(int x : stones) 
            total += x;

        int target = total / 2;
        int n = stones.length;

        dp = new Integer[n+1][target+1];
        int best = solve(stones, n, target);
        return total - 2 * best;
    }
    int solve(int[] stones, int n, int sum){
        if(n == 0 || sum == 0) 
            return 0;

        if(dp[n][sum] != null) 
            return dp[n][sum];

        if(stones[n-1] <= sum){
            return dp[n][sum] = Math.max(stones[n-1] + solve(stones, n-1, sum - stones[n-1]),solve(stones, n-1, sum));
        } else {
            return dp[n][sum] = solve(stones, n-1, sum);
        }
    }
}