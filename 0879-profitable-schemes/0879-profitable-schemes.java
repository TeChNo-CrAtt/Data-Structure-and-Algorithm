class Solution {
    int mod = 1_000_000_007;
    private int helper(int[] profit, int[] group, int minProfit, int totalProfit,int n,int i, int[][][] dp){
        if(i == profit.length){
            if(minProfit <= totalProfit){
                return 1; // this will calc the total schemes / ways
            }
            else{
                return 0;
            }
        }
        totalProfit = Math.min(minProfit,totalProfit);
        if(dp[i][n][totalProfit] != -1){
            return dp[i][n][totalProfit];
        }
        int pick = 0;
        if(n>=group[i]){
            pick = helper(profit , group , minProfit , totalProfit + profit[i] , n-group[i] , i+1 , dp);
        }
        int notPick = helper(profit,group,minProfit,totalProfit,n,i+1,dp);
        return dp[i][n][totalProfit] = (pick + notPick) % mod;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[profit.length+1][n+1][minProfit + 1];
        for(int i=0; i < profit.length; i++){
            for(int j=0; j<=n; j++){
                for(int k=0; k<=minProfit; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(profit,group,minProfit,0,n,0,dp);
    }
}