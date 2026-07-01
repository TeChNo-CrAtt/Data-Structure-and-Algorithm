class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        dp = new int[n+1][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, -1, arr);
    }
    public int solve(int index, int prevIndex, int[] arr) {
        if (index == arr.length)
            return 0;
        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];
        int notTake = solve(index + 1, prevIndex, arr);
        int take = 0;
        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            take = 1 + solve(index + 1, index, arr);
        }
        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }
}

// class Solution {
//     public int lengthOfLIS(int[] arr) {
//         int n = arr.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         int ans = 1;
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (arr[j] < arr[i]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             ans = Math.max(ans, dp[i]);
//         }
//         return ans;
//     }
// }
