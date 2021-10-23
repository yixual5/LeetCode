class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = (long) -1e10 - 1L;
        long right = (long) 1e10 + 1L;
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            long count = 0;
            for (int num : nums1) {
                
                int l = 0;
                int r = nums2.length;
                if (num > 0) {
                    while (l < r) {
                        int m = l + (r - l) / 2;
                        if (mid >= (long) nums2[m] * num) {
                            l = m + 1;
                        } else {
                            r = m;
                        }
                    }
                    count += l;
                } else if (num == 0) {
                    count += mid >= 0 ? nums2.length : 0;
                } else {
                    while (l < r) {
                        int m = l + (r - l) / 2;
                        if (mid >= (long) nums2[m] * num) {
                            r = m;
                        } else {
                            l = m + 1;
                        }
                    }
                    count += nums2.length - l;
                }

            }
            
            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1L;
            }
        }
        return left;
    }
}