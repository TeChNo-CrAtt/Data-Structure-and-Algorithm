class Solution {

    int[][] dp;
    int n;

    public int maxProfit(int[] p) {
        n = p.length;
        dp = new int[n + 1][2];

        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return f(0, 0, p);
    }
    int f(int i, int b, int[] p) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][b] != -1) {
            return dp[i][b];
        }
        int x, y;
        if (b == 0) {
            x = -p[i] + f(i + 1, 1, p);
            y = f(i + 1, 0, p);
        } else {
            x = p[i] + f(i + 2, 0, p);
            y = f(i + 1, 1, p);
        }
        return dp[i][b] = Math.max(x, y);
    }
}