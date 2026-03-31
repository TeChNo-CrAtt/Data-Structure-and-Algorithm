class Solution {

    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, prices);
    }

    int helper(int i, int buy, int[] prices) {
        if (i == prices.length) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];
        int profit;
        if (buy == 0) {
            int take = -prices[i] + helper(i + 1, 1, prices);
            int notTake = helper(i + 1, 0, prices);
            
            profit = Math.max(take, notTake);
        } else {
            int sell = prices[i] + helper(i + 1, 0, prices);
            int notSell = helper(i + 1, 1, prices);

            profit = Math.max(sell, notSell);
        }

        return dp[i][buy] = profit;
    }
}