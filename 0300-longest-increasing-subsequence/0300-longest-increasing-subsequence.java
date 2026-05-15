// class Solution {
//     int[] dp;
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         dp =  new int[n];
//         Arrays.fill(dp , -1);
//         int res = Integer.MIN_VALUE;

//         for(int i = 0 ; i < n ; i++){
//             res = Math.max(res , solve(nums , i, dp));
//         }
//         return res;
//     }
//     public int solve(int[] nums , int index , int dp[] ){
//         if(index == nums.length){
//             return 0;
//         }
//         if(dp[index] != -1) 
//             return dp[index];

//         int ans = 1;
//         for(int j = 0 ; j < index ; j ++){
//             if(nums[j] < nums[index]){
//                 ans = Math.max(ans,(solve(nums,j, dp) +1));
//             }
//         }
//         return dp[index] = ans;
//     }
// }


class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
