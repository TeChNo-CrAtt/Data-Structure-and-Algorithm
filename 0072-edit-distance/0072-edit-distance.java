class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        dp = new int[n1][n2];
        for(int[] d : dp)
            Arrays.fill(d , -1);

        return solve(word1 , word2 , 0 , 0);
    }

    private int solve(String w1, String w2, int i, int j) {
        if (i == w1.length()) 
            return w2.length() - j;
        if (j == w2.length()) 
            return w1.length() - i;

        if(dp[i][j] != -1)
            return dp[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            return solve(w1, w2, i + 1, j + 1);
        }
        int insert = solve(w1, w2, i, j + 1);
        int delete = solve(w1, w2, i + 1, j);
        int replace = solve(w1, w2, i + 1, j + 1);

        return dp[i][j] =  1 + Math.min(insert, Math.min(delete, replace));
    }
}