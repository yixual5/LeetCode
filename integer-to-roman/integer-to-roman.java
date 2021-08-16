class Solution {
    public String intToRoman(int num) {
        int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < val.length; i++) {
            while (val[i] <= num) {
                num -= val[i];
                sb.append(s[i]);
            }
            if (num == 0) return sb.toString();
        }
        return sb.toString();
    }
}