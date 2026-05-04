class Solution {
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int[][] dp=new int[n+1][target+1];
        for(int[] num:dp){
            Arrays.fill(num,-1);
        }
        
        
        return solve(nums,target,0,0,dp);
    }
    public int solve(int[] nums, int target, int i,int sum,int[][]dp ){
        int n=nums.length;
        if(i==n){
            return sum==target ?1:0;

        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int pick=0;
        
        if(sum+nums[i]<=target){
            pick= solve(nums,target,i+1,sum+nums[i],dp);
        }
        int skip=solve(nums,target,i+1,sum,dp);

        return dp[i][sum]=pick+skip;
    }
}