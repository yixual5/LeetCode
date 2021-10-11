class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < prefix.length; i++) {
            if (prefix[i - 1] == prefix[prefix.length - 1] - prefix[i]) return i - 1;
        }
        return -1;
    }
}