class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while (s.peek() != -1 && heights[s.peek()] >= heights[i]) {
                int cur = heights[s.pop()];
                max = Math.max(cur * (i - s.peek() - 1), max);
            }
            s.push(i);
        }
        while (s.peek() != -1) {
            max = Math.max(heights[s.pop()] * (heights.length  - s.peek() - 1), max);
        }
        return max;
    }
}