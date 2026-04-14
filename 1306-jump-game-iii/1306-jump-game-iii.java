class Solution {
    Boolean[] dp;
    public boolean canReach(int[] arr, int start) {
       dp = new Boolean[arr.length];

       return solve(start, arr);
    }
    private boolean solve(int i, int arr[] ){
       if(i<0|| i>=arr.length)return false;// for OBI
       if(arr[i]==0)return true; // valid or we reached at index which gives the value 0;
       if(dp[i] != null)return dp[i];// dp

       dp[i]=false;

       return dp[i]=solve(i+arr[i],arr) || solve(i-arr[i],arr);




    }
}