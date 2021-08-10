class Solution {
    int idx = 0;
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return null;
        StringBuffer sb = new StringBuffer();
        char[] c = s.toCharArray();
        return decode(c, 0);
    }
    
    private String decode(char[] c, int repeat) {
        StringBuffer sb = new StringBuffer();
        while (idx < c.length) {
            
            if (Character.isDigit(c[idx])) {
                repeat = repeat * 10 + (int)(c[idx++] - '0');
            } else if (c[idx] == '[') {
                idx++;
                String s = decode(c, 0);
                sb.append(s.repeat(repeat));
                repeat = 0;
            } else if (c[idx] == ']') {
                idx++;
                break;
            } else if ((int)(c[idx] - 'a') < 26) {
                StringBuffer sb1 = new StringBuffer();
                while (idx < c.length && Character.isLetter(c[idx])) {
                    sb1.append(c[idx++]);
                }
                sb.append(sb1.toString().repeat(repeat == 0 ? 1 : repeat));
            }
        }
        return sb.toString();
    }
}