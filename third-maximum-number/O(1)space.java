class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        long maxm = (long)Integer.MIN_VALUE - 1;
        long second = (long)Integer.MIN_VALUE - 1;
        long third = (long)Integer.MIN_VALUE - 1;
        for (int num: nums) {
            if (num > maxm) {
                third = second;
                second = maxm;
                maxm = num;
                
                
            } else if (num > second && num < maxm) {
                third = second;
                second = num;
                
            } else if (num > third && num < second) {
                third = num;
            }
        }
        if (third == (long)Integer.MIN_VALUE - 1) return (int) maxm;
        return (int) third;
        
    }
}
