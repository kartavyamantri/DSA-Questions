class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = (start + end) / 2;
            if(mid % 2 == 1) mid--;
            if(nums[mid] == nums[mid + 1]) start = mid + 2;
            else end = mid;
        }
        return nums[start];
    }
}