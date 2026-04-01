class Solution {
    int[][][] dp;
    private int helper(int n,int i,int a,int l){
        int mod=1_000_000_007;
        int ans=0;
        if(i==n){
            return 1;
        }
        if(dp[i][a][l]!=-1){
            return dp[i][a][l];
        }
        ans=(ans+helper(n,i+1,a,0))%mod;
        if(a<1){
            ans=(ans+helper(n,i+1,a+1,0))%mod;
        }
        if(l<2){
            ans=(ans+helper(n,i+1,a,l+1))%mod;
        }
        return dp[i][a][l]=ans;
    }
    public int checkRecord(int n) {
        dp=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(n,0,0,0);
    }
}