class Solution {
    public boolean checkPalindrome(String str , int i , int j ){
        while(i<=j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
    
    public int countSubstrings(String s) {
        int i = 0 ;
        int count = 0;
        while(i < s.length()){
            for(int j = i ; j < s.length() ; j++){
                boolean flag = checkPalindrome(s , i , j);
                if(flag == true)
                    count++;
                
            }
            i++;
        }
        return count;
    }
    
}