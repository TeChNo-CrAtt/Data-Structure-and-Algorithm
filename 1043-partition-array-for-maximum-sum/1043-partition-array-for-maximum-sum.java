
class Solution {
    Integer dp[];
    public int solve(int i , int arr[] , int k ){
        if(i == arr.length){
            return 0;
        }
        if(dp[i] != null){
            return dp[i];
        }
        int ans = 0;
        int maxi = 0;
        for(int j = i ; j < arr.length && j < (i + k) ; j++){
            maxi = Math.max(maxi , arr[j]);
            int len = j - i + 1;
            ans = Math.max(ans , (len * maxi) + solve(j + 1 , arr , k));
        }
        return dp[i] = ans ;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length + 1];
        return solve( 0 , arr , k);
        
    }
}