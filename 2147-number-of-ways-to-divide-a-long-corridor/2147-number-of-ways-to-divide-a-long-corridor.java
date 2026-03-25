public class Solution{
    int mod= 1000000007;

    public int numberOfWays(String corridor){
        ArrayList<Integer>posSeats = new ArrayList<>();

        for(int i=0; i<corridor.length(); i++){
            if(corridor.charAt(i)=='S'){
                posSeats.add(i);
            }
        }
        if(posSeats.size()%2!=0 ||posSeats.size()==0){
            return 0;
        }
        long result=1;
        int prev = posSeats.get(1);

        for(int i= 2; i<posSeats.size(); i+=2){
            int length = posSeats.get(i)-prev;

            result = (result*length)%mod;

            prev= posSeats.get(i+1);
        }
        return (int) result;
    }

}


// class Solution {
//     public int numberOfWays(String s) {       
//         int mod = 1000000007;
//         int n = s.length(); 
//         int seat = 0;        
//         for (int i = 0; i < n; i++) {
//             if (s.charAt(i) == 'S') seat++;
//         }
//         if (seat == 0 || seat % 2 == 1) return 0;       
//         long ans = 1;
//         int cnt = 0;     
//         int seen = 0;            
//         for (int i = 0; i < n; i++) {           
//             char c = s.charAt(i);            
//             if (c == 'S') {
//                 seen++;              
//                 if (seen > 2 && seen % 2 == 1) {
//                     ans = (ans * (cnt + 1)) % mod;
//                     cnt = 0;
//                 }
//             } 
//             else {
//                 if (seen >= 2 && seen % 2 == 0) {
//                     cnt++;
//                 }
//             }
//         }       
//         return (int)ans;
//     }
// }