class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    private int atMostK(int[] nums, int k) {
        int res = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) k--;
            while (k < 0) {
                k += nums[left++] % 2;
            }
            res += right - left + 1;
        }
        return res;
    }
}