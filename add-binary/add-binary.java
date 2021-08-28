class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1') carry++;
            if (b.charAt(j) == '1') carry++;
            if (carry % 2 == 0) sb.append('0');
            else sb.append('1');
            carry /= 2;
            j--;
            i--;
        }
        for (int k = i; k >= 0; k--) {
            if (a.charAt(k) == '1') carry++;
            if (carry % 2 == 0) sb.append('0');
            else sb.append('1');
            carry /= 2;
        }
        for (int k = j; k >= 0; k--) {
            if (b.charAt(k) == '1') carry++;
            if (carry % 2 == 0) sb.append('0');
            else sb.append('1');
            carry /= 2;
        }
        if (carry == 1) sb.append('1');
        return sb.reverse().toString();
    }
}