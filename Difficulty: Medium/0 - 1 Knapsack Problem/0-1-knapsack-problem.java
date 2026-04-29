class Solution {
    public int knapsack(int W, int val[] , int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1 ; j <= W; j++) {
                //capacity
                int pick=0;
                int notPick=0;
                
                if (wt[i - 1] <= j) {
                    pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                }
                notPick=dp[i-1][j];
                dp[i][j]=Math.max(pick,notPick);
            }
        }

    return dp[n][W];
    
    }
}