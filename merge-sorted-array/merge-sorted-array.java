class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m;
        int j = n;
        int idx = nums1.length;
        while (i > 0 && j > 0) {
            if (nums1[i - 1] > nums2[j - 1]) nums1[--idx] = nums1[--i];
            else nums1[--idx] = nums2[--j];
        }
        while (j > 0) {
            nums1[--idx] = nums2[--j];
        }
    }
}