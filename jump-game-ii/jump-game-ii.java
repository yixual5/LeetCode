//greedy, take the furthest jump from the range of current jump range
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curEnd = 0, jumps = 0, next = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            next = Math.max(next, nums[i] + i);
            if (next > nums.length - 2) return jumps;
            if (i == curEnd) {
                jumps++;
                curEnd = next;
            }
        }
        return jumps;
    }
}
