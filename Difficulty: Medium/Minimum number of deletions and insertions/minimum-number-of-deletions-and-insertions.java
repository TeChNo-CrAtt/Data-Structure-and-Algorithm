// User function Template for Java

class Solution {
    int[][] dp;
    public int minOperations(String s1, String s2) {
        // Your code goes here
        int n=s1.length();
        int m=s2.length();
        dp=new int[n+1][m+1];
        
        for(int[] num:dp){
            Arrays.fill(num,-1);
        }
        return solve(s1,s2,0,0);
    }
    public int solve(String s1, String s2,int i,int j){
        if(i==s1.length()) return s2.length()-j;
        if(j==s2.length()) return s1.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=solve(s1,s2,i+1,j+1);
        }
        int delete=1+solve(s1,s2,i+1,j);
        int insert=1+solve(s1,s2,i,j+1);
        return dp[i][j]=Math.min(delete,insert);
    }

}