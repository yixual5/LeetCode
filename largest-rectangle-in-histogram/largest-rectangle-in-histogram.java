class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (s.peek() != -1 && heights[s.peek()] >= h) {
                int cur = heights[s.pop()];
                max = Math.max(cur * (i - s.peek() - 1), max);
            }
            s.push(i);
        }
        
        return max;
    }
}

// using two array to simulate the function of stack, same theoritcal runtime but in practice faster
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int[] leftsmaller = new int[heights.length];
        int[] rightsmaller = new int[heights.length];
        leftsmaller[0] = -1;
        rightsmaller[heights.length - 1] = heights.length;
        for (int i = 1; i < heights.length; i++) {
            int prev = i - 1;
            // find the prev smaller left value immediately before i
            while (prev >= 0 && heights[i] <= heights[prev]) {
                prev = leftsmaller[prev];
            }
            leftsmaller[i] = prev;
        }
        for (int i = heights.length - 2; i >= 0; i--) {
            int prev = i + 1;
            // find the prev smaller right value immediately after i
            while (prev < heights.length && heights[i] <= heights[prev]) {
                prev = rightsmaller[prev];
            }
            rightsmaller[i] = prev;
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (rightsmaller[i] - leftsmaller[i] - 1) * heights[i]);
        }
        return max;
    }
}
