class Solution {
    Integer[][] dp;
    public int change(int amount, int[] coins) {

        int n = coins.length;
        dp = new Integer[n+1][amount+1];
        return solve(coins, n, amount);
    }
    int solve(int[] coins, int n, int amount){
        if(amount == 0)
            return 1;
        if(n == 0) 
            return 0;

        if(dp[n][amount] != null) 
            return dp[n][amount];

        if(coins[n-1] <= amount){
            return dp[n][amount] = solve(coins, n, amount - coins[n-1]) + solve(coins, n-1, amount); 
        } else {
            return dp[n][amount] = solve(coins, n-1, amount);
        }
    }
}