class Solution {
    public int minInsertions(String s) {
        return s.length() - LCS(s); 
    }
    public int LCS(String s)
    {
        String r = "";
        for(int i=s.length()-1; i>=0; i--)
        {
            r += s.charAt(i);
        }
        
        int dp[][] = new int[s.length()+1][r.length()+1];

        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[0].length; j++)
            {
                if(s.charAt(i-1) == r.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[s.length()][r.length()];
    }
}