class Solution {
     static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
       return helper(0,0,s1,s2,dp);
    }
    static int helper(int i, int j,String s1, String s2, int[][]dp)
    {
        if(i==s1.length() || j==s2.length())
            return 0;
        if(dp[i][j] != -1) 
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1+helper(i+1,j+1,s1,s2,dp);
            return dp[i][j];
        }else{
            dp[i][j]= Math.max(helper(i+1,j,s1,s2,dp),helper(i,j+1,s1,s2,dp));
            return dp[i][j];
        }
    }
}