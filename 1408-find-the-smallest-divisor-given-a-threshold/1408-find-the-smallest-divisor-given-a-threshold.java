class Solution {
    public int sumByDiv(int[] nums, int div) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double) nums[i] / (double) div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i : nums) max = Math.max(max, i);

        int start = 0, end = max;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(sumByDiv(nums, mid) <= threshold) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }
}