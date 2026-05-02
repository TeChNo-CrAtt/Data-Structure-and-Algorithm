class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        
        for(int i=1; i<=n; i++) {
            if(i != rotate(i)) {
                count++;
            }
        }

        return count;
    }

    public int rotate(int n) {
        StringBuilder sb = new StringBuilder();
        int num = n;

        while(n > 0) {
            int rem = n % 10;

            if(rem == 3 || rem == 4 || rem == 7) {
                return num;
            } else if(rem == 2) {
                sb.insert(0, 5);
            } else if(rem == 5) {
                sb.insert(0,  2);
            } else if(rem == 6) {
                sb.insert(0, 9);
            } else if(rem == 9) {
                sb.insert(0, 6);
            } else {
                sb.insert(0, rem);
            }

            n = n / 10;
        }

        return Integer.valueOf(sb.toString());
    }
} 