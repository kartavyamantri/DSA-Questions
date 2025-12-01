class Solution {
    public boolean possible(int[] batteries, long mid, int n) {
        long target = n * mid;
        long sum = 0;

        for(int i = 0; i < batteries.length; i++) {
            sum += Math.min((long) batteries[i], mid);
            if(sum >= target) return true;
        }

        return false;
    }

    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        long left = Integer.MAX_VALUE;
        for(int b: batteries) {
            sum += b;
            left = Math.min(left, b);
        }
        long right = sum / n;
        long result = 0;

        while(left <= right) {
            long mid = left + (right - left) / 2;
            if(possible(batteries, mid, n)) {
                result = mid;
                left = mid + 1;
            } else right = mid - 1;
        }

        return result;
    }
}