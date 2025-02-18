class Solution {
    public String smallestNumber(String pattern) {
        int top = 0;
        int[] s = new int[10];
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        s[0] = 1;

        for(int i = 0; i < n; i++) {
            if(pattern.charAt(i) == 'I') {
                while(top >= 0) result.append(s[top--]);
            }
            s[++top] = i + 2;
        }
        while(top >= 0) result.append(s[top--]);
        return result.toString();
    }
}