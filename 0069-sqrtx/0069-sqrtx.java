class Solution {
    public int mySqrt(int x) {
        // if(x == 0) return 0;
        // int ans = 1;
        // for(int i = 1; i <= Math.sqrt(x); i++) {
        //     if(i * i <= x) {
        //         ans = i;
        //     }
        // }
        // return ans;

        int low = 0, high = (int) Math.sqrt(x);
        while(low <= high) {
            int mid = (low + high) / 2;
            if(mid * mid == x) return mid;
            else if(mid * mid > x) high = mid - 1;
            else low = mid + 1;
        }
        return high;
    }
}