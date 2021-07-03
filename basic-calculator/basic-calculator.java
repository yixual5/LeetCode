class Solution {
    private char[] temp;
    private int idx;
    public int calculate(String s) {
        
        temp = s.toCharArray();
        idx = 0;
        return helper(s);
        
    }
    
    private int helper(String s) {
        int result = 0;
        int oper = 0;
        int mode = 1;
        while (idx < s.length()) {
            char c = temp[idx++];
            if (Character.isDigit(c)) {
                oper = oper * 10 + (int) (c - '0');
            } else if (c == '(') {
                oper = helper(s);
            } else if (c == ')') {
                break;
            } else if (c == '+') {
                result += mode * oper;
                mode = 1;
                oper = 0;
            } else if (c == '-') {
                result += mode * oper;
                mode = -1;
                oper = 0;
            }
        }
        return result + mode * oper;
    }
}