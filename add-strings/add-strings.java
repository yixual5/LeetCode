//
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        long n1 = 0;
        long n2 = 0;
        if (num1.length() > num2.length()) {
            char[] temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int dif = s2.length - s1.length;
        boolean add1 = false;
        StringBuffer sb = new StringBuffer();
        for (int i = s2.length - 1; i >= dif; i--) {
            int i1 = s1[i - dif] - '0';
            int i2 = s2[i] - '0';
            if (add1) i1++;
            if (i1 + i2 >= 10) {
                add1 = true;
            } else {
                add1 = false;
            }
            sb.insert(0, ((i1 + i2) % 10));
        }
        if (dif == 0 && add1) {
            sb.insert(0, 1);
            return sb.toString();
        }
        for (int i = dif - 1; i >= 0; i--) {
            if (add1) {
                sb.insert(0, (s2[i] + 1 - '0') % 10);
                if ((s2[i] + 1 - '0') % 10 != 0) {
                    add1 = false;
                }
            } else {
                sb.insert(0, s2[i] - '0');
            }
        }
        if (add1) sb.insert(0, 1);
        
        return sb.toString();
    }
}
