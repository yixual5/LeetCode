class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int n = nums.length - 1;
        if (nums[0] == nums[n]) return 0;
        int res = nums[n] - nums[0];
        for (int i = n - 1; i >= 1; i--) {
            //if (nums[i + 1] == nums[i]) continue;
            if (nums[i] == nums[0]) return res;
            nums[i] += res;
            res += nums[i] - nums[i + 1];
        }
        return res;
    }
}