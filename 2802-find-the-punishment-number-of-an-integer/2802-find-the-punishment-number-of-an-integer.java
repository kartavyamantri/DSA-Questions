class Solution {

    public boolean backtrack(String num, int target, int start, int curr) {
        if(curr > target) return false;
        if(start == num.length()) return curr == target;

        for(int end = start + 1; end <= num.length(); end++) {
            String partStr = num.substring(start, end);
            int part = Integer.parseInt(partStr);
            if(backtrack(num, target, end, curr + part)) return true;
        }

        return false;
    }

    public boolean canPartition(String num, int target) {
        int length = num.length();
        return backtrack(num, target, 0, 0);
    }

    public int punishmentNumber(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            int squared = i * i;
            if(canPartition(String.valueOf(squared), i)) sum += squared;
        }
        return sum;
    }
}