class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] count = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0) {
                count[nums[i]] = true;
            }
        }
        for (int i = 1; i < count.length; i++) {
            if (!count[i]) {
                return i;
            }
        }
        return count.length;
    }
}