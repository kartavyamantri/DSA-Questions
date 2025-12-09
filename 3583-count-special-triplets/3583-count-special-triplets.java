class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        Map<Integer, Long> rightMap = new HashMap<>();
        Map<Integer, Long> leftMap  = new HashMap<>();

        for (int num : nums) {
            rightMap.put(num, rightMap.getOrDefault(num, 0L) + 1);
        }

        long count = 0;

        for (int x : nums) {
            rightMap.put(x, rightMap.get(x) - 1);

            long target = (int) x * 2;

            long cntLeft  = leftMap.getOrDefault((int) target, 0L);
            long cntRight = rightMap.getOrDefault((int) target, 0L);

            long add = (cntLeft * cntRight) % MOD;
            count = (count + add) % MOD;

            leftMap.put(x, leftMap.getOrDefault(x, 0L) + 1);
        }

        return (int) (count % MOD);
    }
}