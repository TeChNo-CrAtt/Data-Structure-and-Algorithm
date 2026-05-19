class Solution {
     public static int longestBitonicSequence(int n, int[] nums) {
        // code here
    
        int[] lis=new int[n];
        int[] lds=new int[n];
        Arrays.fill(lis,1);
        Arrays.fill(lds,1);
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    lis[i]=Math.max(lis[i],lis[j]+ 1);
                    
                }
            }
        }
        for (int i = n-1; i>=0; i--) {
            for (int j = n-1; j >= i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                     
                }
            }
        }
        for(int i=0;i<n;i++){
            if(lis[i]>1&&lds[i]>1){
                max=Math.max(max,lis[i]+lds[i]-1);
            }
        }
        return max;
    }
}
    //  public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     for (int i = 0; i < n; i++) {
    //             dp[i] = 1;
    //     }
    //     int ans = Integer.MIN_VALUE;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (nums[j] < nums[i]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //                 ans = Math.max(ans, dp[i]);
    //             }
    //         }
    //     }
    //     return ans == Integer.MIN_VALUE ? 1 : ans;
    // }
    // public int lengthOfLDS(int[] nums) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     for (int i = 0; i < n; i++) {
    //             dp[i] = 1;
    //     }
    //     int ans = Integer.MIN_VALUE;
    //     for (int i = n-1; i <=0; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (nums[j] < nums[i]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //                 ans = Math.max(ans, dp[i]);
    //             }
    //         }
    //     }
    //     return ans == Integer.MIN_VALUE ? 1 : ans;
    // }
  
