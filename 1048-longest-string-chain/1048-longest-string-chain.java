class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public boolean isPredecessor(String s1, String s2) {
        if (s1.length() + 1 != s2.length())
            return false;

        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {

            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++; 
            }
        }

        return i == s1.length();
    }
}