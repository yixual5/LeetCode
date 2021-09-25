class Solution {
    public int shortestSubarray(int[] nums, int k) {
        if ((nums == null || nums.length == 0) && k != 0) return -1;
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        int mi = Integer.MAX_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < preSum.length; i++) {
            while (!q.isEmpty() && preSum[q.getFirst()] + k <= preSum[i]) mi = Math.min(mi, i - q.removeFirst());
            while (!q.isEmpty() && preSum[q.getLast()] >= preSum[i]) q.removeLast();
            q.addLast(i);
        }
        return mi == Integer.MAX_VALUE ? -1 : mi;
    }
}