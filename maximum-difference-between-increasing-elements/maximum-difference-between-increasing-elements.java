class Solution {
    public int maximumDifference(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int mi = nums[0];
        int mx = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > mi) mx = Math.max(nums[i] - mi, mx);
            else mi = Math.min(mi, nums[i]);
        }
        return mx;
    }
}