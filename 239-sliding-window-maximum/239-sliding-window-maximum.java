class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a1, a2) -> nums[a2] - nums[a1]);
        for (int i = 0; i < k; i++) pq.add(i);
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[pq.peek()];
        for (int i = k; i < nums.length; i++) {
            pq.add(i);
            while (!pq.isEmpty() && i - pq.peek() >= k) pq.remove();
            res[i - k + 1] = nums[pq.peek()];
        }
        return res;
    }
}