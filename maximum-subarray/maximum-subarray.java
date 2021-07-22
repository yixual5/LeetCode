class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int mx = nums[0];
        int right = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            while (sum >= 0 && i < nums.length) {
                sum += nums[i++];
                mx = Math.max(mx, sum);
            }
            i--;
            sum = 0;
        }
        return mx;
    }
}