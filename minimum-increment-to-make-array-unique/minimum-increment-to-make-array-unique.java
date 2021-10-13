class Solution {
    public int minIncrementForUnique(int[] nums) {
        int step = 0, remain = 0;
        int mx = 0;
        for (int num : nums) mx = Math.max(mx, num);
        int[] count = new int[nums.length + mx];
        for (int i = 0; i < nums.length; i++) count[nums[i]]++;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                step -= (count[i] - 1) * i;
                remain += count[i] - 1;
            } else if (remain > 0 && count[i] == 0) {
                step += i;
                remain--;
            }
        }
        return step;
    }
}