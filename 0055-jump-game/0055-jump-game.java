class Solution {
    Boolean[] dp;
    private boolean helper(int[] nums, int i){
        if(i == nums.length-1) return true;
        if(i>nums.length) return false;
        if(dp[i] != null){
            return dp[i];
        }
        for(int j=1; j<=nums[i]; j++){
         if(helper(nums,i+j)) return dp[i] = true;
        }
        return dp[i] = false;
    }
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return helper(nums,0);
    }
}


// class Solution {
//     public boolean canJump(int[] nums) {
//        int reachable = 0;
//        for(int i = 0; i < nums.length; i ++) {
//            if(i > reachable) return false;
//            reachable = Math.max(reachable, i + nums[i]);
//        } 
//        return true;
//     }
// }