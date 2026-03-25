class Solution {
    int n;
    int[][] dp;

    public int solve(int[][] events, int i, int k) {
        if (k <= 0 || i >= n)
            return 0;

        if (dp[i][k] != -1)
            return dp[i][k];

        int start = events[i][0];
        int end = events[i][1];
        int value = events[i][2];

        int nextIndex = upperBound(events, end);

        int take = value + solve(events, nextIndex, k - 1);
        int skip = solve(events, i + 1, k);

        return dp[i][k] = Math.max(take, skip);
    }

    public int upperBound(int[][] events, int endTime) {
        int left = 0, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (events[mid][0] > endTime)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        n = events.length;
        dp = new int[n][k + 1];

        for(int i=0 ; i<n ; i++)
            Arrays.fill(dp[i],-1);

        return solve(events , 0, k);
    }
}


// class Solution {
//     static int[][] dp;
    
//     public int solve(int i,int k,int[][] events){

//         if(i == events.length || k == 0) 
//             return 0;
//         if(dp[i][k] != -1) 
//             return dp[i][k];

//         int skip = solve(i+1,k,events);

//         int next = nextindex(events,events[i][1]);
//         int take = events[i][2] + solve(next,k-1,events);

//         return dp[i][k] = Math.max(skip,take);
//     }
//     public int nextindex(int[][] events, int end){
//         int low = 0;
//         int n = events.length;

        
//         while(low < n){
//             int mid = low + (n-low)/2;
        
//             if(events[mid][0] > end){
//                 n = mid;
//             }else{
//                low = mid +1;
//             }
//         }
//         return low;

//     }
//     public int maxValue(int[][] events, int k) {
//         Arrays.sort(events, (a,b) -> a[0]-b[0]);
//         dp = new int[events.length][k+1];
//         for(int i=0;i<events.length;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return solve(0,k,events);


        
//     }
// }

