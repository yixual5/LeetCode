class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.getLast()] < height[i]) {
                int idx = stack.removeLast();
                res += stack.isEmpty() ? 0 : (Math.min(height[stack.getLast()], height[i]) - height[idx]) * (i - stack.getLast() - 1);
            }
            stack.addLast(i);
        }
        return res;
    }
}