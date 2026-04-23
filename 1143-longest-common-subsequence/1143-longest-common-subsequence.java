class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
       return lcs(0,0,text1,text2,dp);
    }
    public int lcs(int i, int j,String s1, String s2, int[][]dp)
    {
        if(i==s1.length() || j==s2.length())
            return 0;
        if(dp[i][j] != -1) 
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1+lcs(i+1,j+1,s1,s2,dp);
            return dp[i][j];
        }else{
            dp[i][j]= Math.max(lcs(i+1,j,s1,s2,dp),lcs(i,j+1,s1,s2,dp));
            return dp[i][j];
        }
    }
}

// class Solution {
//     public String printLCS(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         int[][] dp = new int[n + 1][m + 1];

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         int i = n, j = m;
//         StringBuilder lcs = new StringBuilder();
//         while (i > 0 && j > 0) {
//             if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                 lcs.append(text1.charAt(i - 1));
//                 i--;
//                 j--;
//             }
//             else if (dp[i - 1][j] > dp[i][j - 1]) {
//                 i--;
//             } else {
//                 j--;
//             }
//         }
//         return lcs.reverse().toString();
//     }
// }
