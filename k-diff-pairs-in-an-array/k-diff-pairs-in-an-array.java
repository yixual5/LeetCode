class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int right = 0;
        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            if (left != 0 && nums[left - 1] == nums[left]) continue;
            right = left + 1;
            while (right < nums.length && nums[right] - nums[left] < k) right++;
            if (right < nums.length && nums[right] - nums[left] == k) res++;
            
        }
        return res;
    }
}