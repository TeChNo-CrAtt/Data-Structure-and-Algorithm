class Solution {
    public int robber(int[] nums,int i,int start,int [] dp){
        if(i<start) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        int pick = nums[i] + robber(nums, i - 2, start,dp);
        int notPick = robber(nums, i - 1,start,dp);
        dp[i] = Math.max(pick,notPick);
        return dp[i];
    }

    public int rob(int[] nums) {
        int i = nums.length;
        int [] dp = new int[i+1];
        for(int j=0; j<dp.length;j++){
            dp[j] = -1;
        }
        int[] dp2 = new int[i+1];
         for(int j=0; j<dp2.length;j++){
            dp2[j] = -1;
        }
        if(i<0) return 0;
        if (i == 1)
            return nums[0];
         int case1 = robber(nums,i-2,0,dp);   
         int case2 = robber(nums,i-1,1,dp2);   
        return Math.max(case1,case2); 
    }
}


// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1) return nums[0];
        
//         int[] dp1 = new int[n];
//         Arrays.fill(dp1, -1);
//         int case1 = robber(nums, 0, n - 2, dp1);

//         int[] dp2 = new int[n];
//         Arrays.fill(dp2, -1);
//         int case2 = robber(nums, 1, n - 1, dp2);

//         return Math.max(case1, case2);
//     }

//     private int robber(int[] nums, int i, int end, int[] dp) {
//         if (i > end)
//             return 0;

//         if (dp[i] != -1)
//             return dp[i];

//         int p1 = nums[i] + robber(nums, i + 2, end, dp);
//         int p2 = robber(nums, i + 1, end, dp);

//         return dp[i] = Math.max(p1, p2);
//     }
// }
