class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || k == num.length()) return "0";
        StringBuffer sb = new StringBuffer();
        for (char c : num.toCharArray()) {
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }
        sb.setLength(sb.length() - k);
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}