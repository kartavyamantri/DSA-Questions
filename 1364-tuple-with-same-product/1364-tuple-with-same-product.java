class Solution {
    public int tupleSameProduct(int[] nums) {
        if(nums.length < 4) return 0;

        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                count.put(product, count.getOrDefault(product, 0) + 1);
            }
        }

        int sum = 0;
        for(int c : count.values()) {
            if(c > 1) sum += (c * (c - 1)) / 2;
        }

        return sum * 8;
    }
}