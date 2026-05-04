class Solution {
    
        public int minDifference(int arr[]) {
        // code here
        int n=arr.length;
        int totalSum=0;
        for(int num:arr){
            totalSum+=num;
        }
        int[][] dp=new int[n+1][totalSum+1];
        for(int[] num:dp){
            Arrays.fill(num,-1);
        }
        return solve(arr,0,totalSum,n,dp);
    }
    static int solve(int arr[],int sum,int totalSum,int n,int[][] dp){
        
        if(n==0) return Math.abs((totalSum-sum)-sum);
        
        if(dp[n][sum]!=-1) return dp[n][sum];
        
        int pick=solve(arr,sum+arr[n-1],totalSum,n-1,dp);
        
        
        int skip=solve(arr,sum,totalSum,n-1,dp);
        
        return dp[n][sum]=Math.min(pick,skip);
    }

}