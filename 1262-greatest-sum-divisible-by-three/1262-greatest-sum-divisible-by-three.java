class Solution {
    public int maxSumDivThree(int[] nums) {
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        int sum = 0;
        for(int n: nums) {
            sum += n;
            if(n % 3 == 1) r1.add(n);
            else if (n % 3 == 2) r2.add(n);
        }
        if(sum % 3 == 0) return sum;

        Collections.sort(r1);
        Collections.sort(r2);
        int remainder = sum % 3;
        int ans = 0;

        if(remainder == 1) {
            int sum1 = r1.size() >= 1 ? sum - r1.get(0) : 0;
            int sum2 = r2.size() >= 2 ? sum - r2.get(0) - r2.get(1) : 0;
            ans = Math.max(sum1, sum2);
        } else {
            int sum1 = r1.size() >= 2 ? sum - r1.get(0) - r1.get(1) : 0;
            int sum2 = r2.size() >= 1 ? sum - r2.get(0) : 0;
            ans = Math.max(sum1, sum2);
        }
        
        return ans;
    }
}