// O(N)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k == 0) return new int[]{0};
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int block = nums.length / k;
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        // start from 1 because not right is not aligned
        for (int i = 1; i < nums.length; i++) {
            if (i % k == 0) left[i] = nums[i];
            else left[i] = Math.max(left[i - 1], nums[i]);
            
            int j = nums.length - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];
            else right[j] = Math.max(right[j + 1], nums[j]);
        }
        // block i to j: max of right to left of i + max of left to right of j
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(right[i], left[i + k - 1]);
        }
        return result;
    }
}
