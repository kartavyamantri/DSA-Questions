class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        // Brute Force
        // for(int i = 0; i < spells.length; i++) {
        //     int spell = spells[i];
        //     int count = 0;
        //     for(int j = 0; j < potions.length; j++) {
        //         if((long) spell * (long) potions[j] >= success) {
        //             count++;
        //         }
        //     }
        //     res[i] = count;
        // }

        // Binary search
        int n = spells.length;
        int m = potions.length;

        for(int i = 0; i < n; i++) {
            long spell = spells[i];
            int index = binarySearch(0, m - 1, spell, potions, success);
            res[i] = (index == -1) ? 0 : (m - index);
        }
        return res;
    }

    public static int binarySearch(int left, int right, long spell, int[] potions, long success) {
        int index = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(spell * potions[mid] >= success) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}