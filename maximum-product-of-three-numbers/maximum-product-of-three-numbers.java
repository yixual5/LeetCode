class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) throw new IllegalArgumentException();
        int min1 = Integer.MAX_VALUE; //smallest
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;//largest
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (max1 < num) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 < num) {
                max3 = max2;
                max2 = num;
            } else if (max3 < num) {
                max3 = num;
            }
        }
        return Math.max(min1*min2*max1, max1*max2*max3);
    }
}