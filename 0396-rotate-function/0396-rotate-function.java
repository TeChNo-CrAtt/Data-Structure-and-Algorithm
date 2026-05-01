class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long total = 0, curr = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
            curr += (long)i * nums[i];
        }

        long res = curr;
        for (int k = 1; k < n; k++) {
            curr = curr + total - (long)n * nums[n - k];
            res = Math.max(res, curr);
        }
        return (int)res;
    }
}