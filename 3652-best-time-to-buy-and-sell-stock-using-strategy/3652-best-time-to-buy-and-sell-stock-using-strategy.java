class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long actualProfit = 0;
        int[] profit = new int[n];

        for(int i = 0; i < n; i++) {
            profit[i] = strategy[i] * prices[i];
            actualProfit += profit[i];
        }

        long origWinProfit = 0;
        long modWinProfit = 0;
        long maxGain = 0;

        int i = 0, j = 0;

        while(j < n) {
            origWinProfit += profit[j];

            if(j - i + 1 > k / 2) modWinProfit += prices[j];

            if(j - i + 1 > k) {
                origWinProfit -= profit[i];
                modWinProfit -= prices[i + k / 2];
                i++;
            }

            if(j - i + 1 == k) maxGain = Math.max(maxGain, modWinProfit - origWinProfit);

            j++;
        }

        return actualProfit + maxGain;
    }
}