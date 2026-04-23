class Solution {
    int[][] dp;

    public int cutRod(int price[]) {

        // Create weights (lengths)
        int n= price.length;
        int[] wt = new int[n];
        for(int i = 0; i < n; i++){
            wt[i] = i + 1;
        }
        dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return knap(price, wt, n, n);
    }
        int knap(int[] val, int[] wt, int c, int n){
        if(n == 0 || c == 0) return 0;

        if(dp[n][c] != -1) return dp[n][c];

        if(wt[n-1] <= c){
            return dp[n][c] = Math.max(val[n-1] + knap(val, wt, c - wt[n-1], n) , 
                    knap(val, wt, c, n-1));
        } else {
            return dp[n][c] = knap(val, wt, c, n-1);
        }
    }
}