class Solution {
    public int countPartitions(int[] nums) {
        int count = 0;
        int sumB4i = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            sumB4i += nums[i];
            int sumAfteri = 0;
            for(int j = i + 1; j < nums.length; j++) {
                sumAfteri += nums[j];
            }
            if((sumAfteri - sumB4i) % 2 == 0) count++;
        }

        return count;
    }
}