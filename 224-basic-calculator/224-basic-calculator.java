class Solution {
    int idx = 0;
    public int calculate(String s) {
        if (s == null) return 0;
        return helper(s);
    }
    
    private int helper(String s) {
        if (idx >= s.length()) return 0;
        int sign = 1;
        int res = 0;
        int cur = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c == ' ') continue;
            else if (c == '+') {
                res += sign * cur;
                sign = 1;
                cur = 0;
            } else if (Character.isDigit(c)) {
                cur = cur * 10 + (int) (c - '0');
            } else if (c == '-') {
                res += sign * cur;
                sign = -1;
                cur = 0;
            } else if (c == '(') {
                cur = helper(s);
            } else if (c == ')') {
                return res + sign * cur;
            }
        }
        return res + sign * cur;
    }
}