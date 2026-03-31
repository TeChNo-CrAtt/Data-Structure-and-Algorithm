class Solution {
    public int maxProfit(int[] prices) 
    {
        int n=prices.length;
        int bestbuy=prices[0];
        int profit=0;
        for(int i=1;i<n;i++)
        {
            bestbuy=Math.min(bestbuy,prices[i]);
            if(bestbuy < prices[i])
            {
                profit=Math.max(profit , prices[i]-bestbuy);
            }
        }
        return profit;
    }
}