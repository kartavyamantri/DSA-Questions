class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // int k;
        // int max = 0;
        // for(int i = 0; i < piles.length; i++) {
        //     max = Math.max(max, piles[i]);
        // }
        // for(k = 1; k < max; k++) {
        //     int hours = 0;
        //     for(int i = 0; i < piles.length; i++) {
        //         if(piles[i] % k == 0) hours += (piles[i] / k);
        //         else hours += (piles[i] / k) + 1;
        //     }
        //     if(hours <= h) break;
        // }
        // return k;

        int low = 1;
        int high = 0;
        for(int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }
        int ans = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int hours = 0;
            for(int i = 0; i < piles.length; i++) {
                hours += Math.ceil((double) piles[i] / (double) mid);
            }
            if(hours <= h) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }
}