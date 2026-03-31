class Solution {
    int[][][] dp;
    String s;
    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();
        this.s = s;

        dp = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, n - 1, k);
    }

    int solve(int i, int j, int k) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        int ans = 0;
        ans = Math.max(ans, solve(i + 1, j, k));
        ans = Math.max(ans, solve(i, j - 1, k));

        if (s.charAt(i) == s.charAt(j)) {
            ans = Math.max(ans, 2 + solve(i + 1, j - 1, k));
        } else {
            int diff = Math.abs(s.charAt(i) - s.charAt(j));
            int cost = Math.min(diff, 26 - diff);

            if (cost <= k) {
                ans = Math.max(ans, 2 + solve(i + 1, j - 1, k - cost));
            }
        }

        return dp[i][j][k] = ans;
    }
}