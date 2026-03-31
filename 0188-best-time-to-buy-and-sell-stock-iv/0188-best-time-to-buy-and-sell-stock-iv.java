class Solution {
    int[][][] dp;
    int n;
    public int maxProfit(int k, int[] p) {
        n = p.length;
        dp = new int[n][2][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(0, 0, 0, k, p);
    }
    int f(int i, int b, int t, int k, int[] p) {
        if (i == n || t == k) {
            return 0;
        }
        if (dp[i][b][t] != -1) {
            return dp[i][b][t];
        }
        int x, y;
        if (b == 0) {
            x = -p[i] + f(i + 1, 1, t, k, p);
            y = f(i + 1, 0, t, k, p);
        } else {
            x = p[i] + f(i + 1, 0, t + 1, k, p);
            y = f(i + 1, 1, t, k, p);
        }
        return dp[i][b][t] = Math.max(x, y);
    }
}