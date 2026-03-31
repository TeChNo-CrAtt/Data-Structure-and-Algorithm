class Solution {   // mani
    int[][][] dp;
    int[] prices;
    public int solve(int i, int buy, int k, int n){
        int c1=0; 
        int c2=0;
        if(i==n || k==0)return 0;
        if(dp[i][buy][k]!=-1)return dp[i][buy][k];
        if(buy==0){
            c1=-prices[i] + solve(i+1, 1, k, n);
            c2=solve(i+1, 0, k, n);   
        }
        else{
            c1=prices[i] + solve(i+1, 0, k-1, n); 
            c2=solve(i+1, 1, k, n);  
        }
        return dp[i][buy][k]=Math.max(c1, c2);
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        this.prices=prices;
         
        dp=new int[n+1][2][k+1];
        for(int i=0;i<n;i++){
            for(int buy=0;buy<2;buy++){
                for(int t=0;t<=k;t++){
                    dp[i][buy][t]=-1;

                }
            }
        }
        return solve(0, 0, k, n);
    }
}

// class Solution {   //mayank
//     int[][][] dp;
//     int n;
//     public int maxProfit(int k, int[] p) {
//         n = p.length;
//         dp = new int[n][2][k + 1];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < 2; j++) {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }
//         return f(0, 0, 0, k, p);
//     }
//     int f(int i, int b, int t, int k, int[] p) {
//         if (i == n || t == k) {
//             return 0;
//         }
//         if (dp[i][b][t] != -1) {
//             return dp[i][b][t];
//         }
//         int x, y;
//         if (b == 0) {
//             x = -p[i] + f(i + 1, 1, t, k, p);
//             y = f(i + 1, 0, t, k, p);
//         } else {
//             x = p[i] + f(i + 1, 0, t + 1, k, p);
//             y = f(i + 1, 1, t, k, p);
//         }
//         return dp[i][b][t] = Math.max(x, y);
//     }
// }