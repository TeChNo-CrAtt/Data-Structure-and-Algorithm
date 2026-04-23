class Solution {
    
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int i = arr.length;
        return helper(arr,i,sum);
        
    }
    static Boolean helper(int arr[],int i,int sum){
        if(sum==0)
            return true;
        if(i==0)
            return false;
        // boolean notpick=helper(i-1,arr,sum);
        // boolean pick=false;
        if(arr[i-1]<=sum)
            return helper(arr,i-1,sum-arr[i-1])||helper(arr,i-1,sum);
            

        return helper(arr,i-1,sum);
        
    }
}