class Solution {
    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        int r = s.length() - 1, l = 0, ans = 0;
        while(l < r) if(s.charAt(l++) != s.charAt(r--)) ans++;
        return ans * 2;
    }
}