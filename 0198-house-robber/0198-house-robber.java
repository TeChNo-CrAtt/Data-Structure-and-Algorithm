class Solution {
    public int helper(int[] nums, int i,int[] dp){
        if(i<0) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        int case1=nums[i]+helper(nums,i-2,dp);
        int case2=helper(nums,i-1,dp);
        dp[i] = Math.max(case1,case2);
        return dp[i];
    }    
    public int rob(int[] nums) {

        int n=nums.length;
        int dp[]=new int [n+1];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        return helper(nums,nums.length-1,dp); 
        
    }
}

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, -1);
//         return robber(nums, 0, dp);
//     }

//     private int robber(int[] nums, int i, int[] dp) {
//         if (i >= nums.length)
//             return 0;
//         if (dp[i] != -1) 
//             return dp[i]; 
//         int p1 = nums[i] + robber(nums, i + 2, dp);
//         int p2 = robber(nums, i + 1, dp);
//         dp[i] = Math.max(p1, p2);
//         return dp[i];
//     }
// }