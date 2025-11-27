class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        long maxSum = Long.MIN_VALUE;
        // for(int i = 0; i < n; i++) {
        //     for(int j = i + k - 1; j < n; j += k) {
        //         if(i > 0) maxSum = Math.max(maxSum, prefixSum[j] - prefixSum[i - 1]);
        //         else maxSum = Math.max(maxSum, prefixSum[j]);
        //     }
        // }


        for(int start = 0; start < k; start++) {
            int i = start;
            long currSum = 0;

            while(i < n && i + k - 1 < n) {
                int j = i + k - 1;
                long subArrSum = prefixSum[j] - ((i > 0) ? prefixSum[i - 1] : 0);

                currSum = Math.max(subArrSum, subArrSum + currSum);
                maxSum = Math.max(maxSum, currSum);

                i += k;
            }
        }
        return maxSum;
    }
}