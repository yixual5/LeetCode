//from left, find most left position to start
//from right, find most right poision to end
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

//same idea
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        int hi = -2, lo = -1;
        int min = nums[nums.length - 1];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            hi = max > nums[i] ? i : hi;
            min = Math.min(min, nums[nums.length - i - 1]);
            lo = min < nums[nums.length - i - 1] ? nums.length - 1 - i : lo;
        }
        return hi - lo + 1;
    }
}
