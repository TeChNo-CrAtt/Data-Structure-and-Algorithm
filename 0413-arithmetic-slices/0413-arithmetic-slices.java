class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if (n<3) 
            return 0;
        int[] ans = new int[n];
        for(int i=2;i<n;i++){
            int a=nums[i];
            int b=nums[i-1];
            int c=nums[i-2];
            if(a-b == b-c)
                ans[i]=ans[i-1]+1;  
    }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=ans[i];
        }
        return sum;
    }
}