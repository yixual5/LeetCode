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

//ignore intermediate step, when reach buttom - (), we calcualte how many 2 we need multiple
class Solution {
    public int scoreOfParentheses(String s) {
        int layer = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                layer++;
            } else {
                layer--;
                if (s.charAt(i - 1) == '(')result += 1 << layer;
            }
        }
        return result;
    }
}
