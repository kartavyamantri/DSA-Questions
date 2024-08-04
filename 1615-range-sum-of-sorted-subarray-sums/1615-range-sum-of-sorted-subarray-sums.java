class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1_000_000_007;
        int[] prefixSums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
        List<Integer> subArraySums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                subArraySums.add(prefixSums[j] - prefixSums[i]);
            }
        }
        Collections.sort(subArraySums);
        long result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + subArraySums.get(i)) % mod;
        }
        
        return (int) result;
    }
}




        // Brute Force
        // List<Integer> a = new ArrayList<>();
        // for(int i = 0; i < n; i++) {
        //     int sum = 0;
        //     for(int j = i; j < n; j++) {
        //         sum += nums[j];
        //         a.add(sum);
        //     }
        // }
        // Collections.sort(a);
        // int sum = 0;
        // int MOD = 1000000007;
        // for(int i = left - 1; i < right; i++) {
        //     sum += (a.get(i)) % MOD;
        // }
        // return sum;