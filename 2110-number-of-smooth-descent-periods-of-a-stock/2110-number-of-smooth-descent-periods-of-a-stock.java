class Solution {
    public long getDescentPeriods(int[] prices) {
        // int n = prices.length;
        // if(n == 1) return 1;

        // long ans = n;

        // int[] prefixDiff = new int[n];
        // for(int i = 1; i < n; i++) {
        //     prefixDiff[i] = prices[i - 1] - prices[i];
        // }

        // for(int i = 1; i < n; i++) {
        //     int count = 0;
        //     int j = i;
        //     if(prefixDiff[i] == 1) {
        //         while(j < n && prefixDiff[j] == 1) {
        //             count++;
        //             j++;
        //         }
        //     }
        //     ans += count;
        // }

        // return ans;

        long count = 1;
        long ans = 1;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i - 1] - prices[i] == 1) count++;
            else count = 1;
            ans += count;
        }

        return ans;
    }
}