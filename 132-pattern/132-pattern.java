class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        int top = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == min[i]) continue;
            while (top < nums.length && nums[top] <= min[i]) top++;
            if (top < nums.length && nums[top] < nums[i]) return true;
            nums[--top] = nums[i];
        }
        return false;
    }
}