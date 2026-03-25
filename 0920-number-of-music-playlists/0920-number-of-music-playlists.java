// class Solution {
//     public int numMusicPlaylists(int n, int goal, int k) {
//         int mod = 1000000007;
//         long[][] dp = new long[goal + 1][n + 1];
//         dp[0][0] = 1;
//         for (int i = 1; i <= goal; i++) {
//             for (int j = 0; j <= n; j++) {
//                 long addNew = 0;
//                 long addOld = 0;

//                 if (j - 1 >= 0) {
//                     long prev = dp[i - 1][j - 1];
//                     long choices = n - (j - 1);
//                     addNew = (prev * choices) % mod;
//                 }
//                 if (j > k) {
//                     long prev = dp[i - 1][j];
//                     long choices = j - k;
//                     addOld = (prev * choices) % mod;
//                 }
//                 long total = (addNew + addOld) % mod;
//                 dp[i][j] = total;
//             }
//         }
//         long ans = dp[goal][n];
//         return (int) ans;
//     }
// }


class Solution {
    public long helper(int i, int j, int goal, int n, int k, long[][] dp){
        int mod = 1_000_000_007;
        if(i==goal){
            return (j==n) ? 1 : 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        long ans = 0;
        // new song
        if(j<n){
           ans += helper(i+1,j+1,goal,n,k,dp)*(n-j) % mod;
        }
        // old songs
        if(j>k){
            ans += helper(i+1,j,goal,n,k,dp)*(j-k)% mod;
        }
       return dp[i][j] =(ans % mod);
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal+1][n+1];
        for(int i=0; i<=goal; i++){
            Arrays.fill(dp[i],-1);
        }
        return (int)helper(0,0,goal,n,k,dp);
    }
}