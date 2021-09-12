class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int prev = stack.pop();
                int cur = stack.isEmpty() ? 0 : stack.pop();
                stack.push(cur + Math.max(2 * prev, 1));
            }
        }
        return stack.pop();
    }
}