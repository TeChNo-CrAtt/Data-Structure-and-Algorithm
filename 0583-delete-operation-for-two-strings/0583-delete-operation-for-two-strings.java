class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n + 1][m + 1];
        for (int[] row:dp) {
            Arrays.fill(row, -1);
        }
        int lcs = helper(0, 0, word1, word2);
        return n + m - 2 * lcs;  
    }

    private int helper(int i, int j, String word1, String word2) {
        if (i == word1.length() || j == word2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = 1 + helper(i + 1, j + 1, word1, word2);
        }
        else {
            dp[i][j] = Math.max(helper(i + 1, j, word1, word2),helper(i, j + 1, word1, word2));
        }
        return dp[i][j];
    }
}
