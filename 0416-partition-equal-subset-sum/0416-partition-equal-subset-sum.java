class Solution {

    static Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n=nums.length;
       
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        dp= new Boolean[n+1][sum+1];

        if(sum%2 !=0) return false;
        else return solve(nums,n,sum/2);
    }
    boolean solve(int[] nums,int n,int sum){
        if(sum==0) return true;
        if(n==0) return false;
        if(dp[n][sum]!=null) return dp[n][sum];
        if(nums[n-1]<=sum){
            return dp[n][sum]=solve(nums,n-1,sum-nums[n-1]) || solve(nums,n-1,sum);
        }
        else{
            return dp[n][sum]=solve(nums,n-1,sum);
        }
    }
}