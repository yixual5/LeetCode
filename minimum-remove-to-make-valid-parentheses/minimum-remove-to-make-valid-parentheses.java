class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuffer sb = new StringBuffer();
        int left = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sb.append(c);
                left++;
            } else if (left > 0 && c == ')') {
                sb.append(c);
                left--;
            } else if (c != '(' && c != ')') {
                sb.append(c);
            }
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (left == 0) return sb.toString();
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                left--;
            }
        }
        return sb.toString();
    }
}