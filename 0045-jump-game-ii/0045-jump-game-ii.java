class Solution {
    Integer[] dp;

    private int helper(int[] nums, int i) {
        if (i >= nums.length - 1) 
            return 0;

        if (dp[i] != null) return dp[i];

        int minJumps = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
            int next = helper(nums, i + j);

            if (next != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + next);
            }
        }
        return dp[i] = minJumps;
    }

    public int jump(int[] nums) {
        dp = new Integer[nums.length];
        return helper(nums, 0);
    }
}