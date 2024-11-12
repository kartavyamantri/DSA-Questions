class Solution {
    public boolean isPossible(int minDays, int k, int m, int[] bloomDay) {
        int total = 0;
        int count = 0;
        for(int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= minDays) count++;
            else count = 0;
            if (count == k) {
                total++;
                count = 0;
            }
            if (total >= m) {
                return true;
            }
        }
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length) return -1;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i : bloomDay) {
            start = Math.min(start, i);
            end = Math.max(end, i);
        }
        int ans = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(isPossible(mid, k, m, bloomDay)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}