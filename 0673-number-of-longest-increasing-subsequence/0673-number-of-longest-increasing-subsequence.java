class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] lis = new int[n];
        int[] count = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                        count[i] = count[j];
                    }
                    else if (lis[j] + 1 == lis[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, lis[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] == maxLen) {
                ans += count[i];
            }
        }
        return ans;
    }
}