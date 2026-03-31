class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        for(int[] ride : rides){
            List<int[]> values = map.get(ride[1]);
            if(values == null){
                values = new ArrayList<>();
                map.put(ride[1],values);
            }
            values.add(ride);
        }
        long[] dp = new long[n+1];
        for(int i = 2; i <= n; i++){ //1 pr start krne se possible nhi"no end"
            List<int[]> values = map.get(i); //cheaking the passenger ig getting down
            if(values != null){
                long earning = 0;
                for(int[] value : values){
                    earning  = Math.max(earning, value[1]-value[0]+value[2]+dp[value[0]]);
                }
                dp[i] = earning;

            }
            dp[i] = Math.max(dp[i],dp[i-1]);//taking,non taing(till prev)
        }
        return dp[n];
        
    }
}