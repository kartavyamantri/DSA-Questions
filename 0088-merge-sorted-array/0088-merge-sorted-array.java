class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Brute Force

        // int x=0, y=0;
        // if(nums2.length==0) return;
        // for(int i=0;i<m;i++){
        //     if(nums2[y]<nums1[x]){
        //         int temp=nums1[x];
        //         nums1[x]=nums2[y];
        //         nums2[y]=temp;
        //         Arrays.sort(nums2);
        //     }
        //     x++;
        // }
        // Arrays.sort(nums2);
        // for(int i=x;i<m+n;i++){
        //     nums1[i]=nums2[y];
        //     y++;
        // }


        // Better Solution

        // int x=0;
        // for(int i=m+n-1;i>=m;i--){
        //     nums1[i]=nums2[x];
        //     x++;
        // }
        // Arrays.sort(nums1);


        // Optimized solution

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(j >= 0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}