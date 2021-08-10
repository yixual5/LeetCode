class Solution {
    public int calculate(String s) {
        char[] stc = s.toCharArray();
        int cur = 0;
        int prev = 0;
        char mode = '+';
        int result = 0;
        for (char c : stc) {
            if (Character.isDigit(c)) {
                cur = cur * 10 + (int)(c - '0');
            } else if (c == ' ') {
                continue;
            } else if (mode == '+') {
                result += prev;
                prev = cur;
                cur = 0;
                mode = c;
            } else if (mode == '-') {
                result += prev;
                prev = -cur;
                cur = 0;
                mode = c;
            } else if (mode == '/') {
                prev = prev / cur;
                mode = c;
                cur = 0;
            } else if (mode == '*') {
                prev = prev * cur;
                mode = c;
                cur = 0;
            }
        }
        if (mode == '+') {
            return result + prev + cur;
        } else if (mode == '-') {
            return result + prev - cur;
        } else if (mode == '*') {
            return result + prev * cur;
        } else {
            return result + prev / cur;
        }

    }
}