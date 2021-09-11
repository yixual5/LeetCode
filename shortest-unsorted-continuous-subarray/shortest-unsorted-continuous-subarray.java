class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        int lo = nums.length, high = -1;
        for (int i = 0; i < nums.length; i++) {
            while (!s1.isEmpty() && nums[i] < nums[s1.peek()]) {
                lo = Math.min(lo, s1.pop());
            }
            s1.push(i);
            while (!s2.isEmpty() && nums[nums.length - i - 1] > nums[s2.peek()]) {
                high = Math.max(high, s2.pop());
            }
            s2.push(nums.length - i - 1);
        }
        return lo > high ? 0 : high - lo + 1;
    }
}