class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][3];
        return helper(0, 1, 2, prices, dp);
    }

    public int helper(int i, int buy, int transactions, int[] prices, Integer[][][] dp) {
        if (i == prices.length || transactions == 0) return 0;

        if (dp[i][buy][transactions] != null) 
            return dp[i][buy][transactions];

        int profit;

        if (buy == 1) {
            int take = -prices[i] + helper(i + 1, 0, transactions, prices, dp);
            int skip = helper(i + 1, 1, transactions, prices, dp);
            profit = Math.max(take, skip);
        } else {
            int sell = prices[i] + helper(i + 1, 1, transactions - 1, prices, dp);
            int skip = helper(i + 1, 0, transactions, prices, dp);
            profit = Math.max(sell, skip);
        }

        return dp[i][buy][transactions] = profit;
    }
}