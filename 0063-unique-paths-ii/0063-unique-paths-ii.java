class Solution {
    int m,n;
    int dp[][];

    public int solve(int[][] grid,int i,int j){
        if(i>=m||j>=n||grid[i][j]==1) return 0;
        if(dp[i][j]!=-1){
        return dp[i][j];
    }
        if(i==m-1 && j==n-1) return 1;

        int right=solve(grid,i,j+1);
        int down=solve(grid,i+1,j);

        return dp[i][j]=right+down;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        return solve(obstacleGrid,0,0);

    }
}