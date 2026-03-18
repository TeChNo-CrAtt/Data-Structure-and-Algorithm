class Solution {
    public int solve(int i, String s, Set<String> set, int n, int[] dp) {      
        if (i == n) 
            return 1;
        if (dp[i] != -1) 
            return dp[i];
        String temp = "";
        int ans = 0;
        for (int j = i; j < n; j++) {
            temp += s.charAt(j);
            if (set.contains(temp)) {
                ans = ans | solve(j + 1, s, set, n, dp);
            }
        }
        return dp[i] = ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {   
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, s, set, n, dp) == 1;
    }
}