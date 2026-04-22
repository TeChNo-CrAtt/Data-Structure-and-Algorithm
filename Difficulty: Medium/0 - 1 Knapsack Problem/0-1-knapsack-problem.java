class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        for(int[] row : dp)
            Arrays.fill(row , -1);
            
        return helper(W, val,wt,n,dp);
        
    }
    public int helper(int W , int val[] , int wt[] , int n , int[][] dp){
        if(n == 0 || W == 0)
            return 0;
        if(dp[n][W] != -1)
            return dp[n][W];
            
        if(wt[n-1] <= W){
            return dp[n][W] = Math.max(val[n - 1] + helper(W-wt[n-1] , val , wt , n-1 , dp) , helper(W , val , wt , n-1 , dp));
        } else {
            return  dp[n][W] = helper(W , val , wt , n-1 , dp);
        }
    }
}

