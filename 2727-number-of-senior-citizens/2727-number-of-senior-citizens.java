class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(int i = 0; i < details.length; i++) {
            char c1 = details[i].charAt(11);
            char c2 = details[i].charAt(12);
            if((c1 >= '6' && c2 > '0') || (c1 > '6' && c2 >= '0')) count++;
        }
        return count;
    }
}