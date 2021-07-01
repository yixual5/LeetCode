class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) return (double) 0;
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        boolean iseven = (l1 + l2) % 2 == 0;
        if (l1 > l2) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
            l1 = nums1.length;
            l2 = nums2.length;
        }
        if (nums1.length == 0 && nums2.length != 0) {
            return iseven ? (double)(nums2[l2 / 2] + nums2[l2 / 2 - 1]) / 2 : (double)nums2[l2 / 2];
        }
        if (nums2.length == 0) return 0.0;
        int start = 0;
        int end = l1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int part2 = (l1 + l2 + 1) / 2 - mid;
            double nums1maxleft = (mid == 0) ? -Double.MAX_VALUE : nums1[mid - 1];
            double nums1minright = (mid == l1) ? Double.MAX_VALUE : nums1[mid];
            double nums2maxleft = (part2 == 0) ? -Double.MAX_VALUE : nums2[part2 - 1];
            double nums2minright = (part2 == l2) ? Double.MAX_VALUE : nums2[part2];
            if (nums2maxleft <= nums1minright && nums1maxleft <= nums2minright) {
                double temp = (Math.max(nums1maxleft, nums2maxleft) + Math.min(nums1minright, nums2minright)) / 2;
                return iseven ? temp : Math.max(nums1maxleft, nums2maxleft);
            } else if (nums1maxleft > nums2minright){
                end = mid - 1; // move to left part
            } else {
                start = mid + 1;
            }
        }
        return 0.0;
    }
}