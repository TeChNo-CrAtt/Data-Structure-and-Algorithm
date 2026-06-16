class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = solve(coins, amount, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int[] coins, int amount, int[] dp) {
        if (amount == 0)
            return 0;

        if (dp[amount] != -1)
            return dp[amount];

        int ans = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (amount >= coin) {
                int res = solve(coins, amount - coin, dp);

                if (res != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + res);
                }
            }
        }

        return dp[amount] = ans;
    }
}


// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, amount + 1);
//         dp[0] = 0;
//         for (int i = 1; i <= amount; i++) {
//             for (int j = 0; j < coins.length; j++) {
//                 int coin = coins[j];

//                 if (coin <= i) {
//                     dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
//                 }
//             }
//         }
//         return dp[amount] > amount ? -1 : dp[amount];
//     }
// }