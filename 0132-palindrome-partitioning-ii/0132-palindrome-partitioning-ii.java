class Solution {
    int[] dp;
    public int minCut(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s) - 1;
    }

    public int solve(int i, String s) {
        if (i == s.length()) 
            return 0;

        if (dp[i] != -1) 
            return dp[i];

        int minCuts = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                int cuts = 1 + solve(j + 1, s);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        return dp[i] = minCuts;
    }
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) 
                return false;
        }
        return true;
    }
    
}