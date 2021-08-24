class Solution {
    public String originalDigits(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int[] num = new int[10];
        num[8] = count['g' - 'a'];
        num[0] = count['z' - 'a'];
        num[2] = count['w' - 'a'];
        num[4] = count['u' - 'a'];
        num[6] = count['x' - 'a'];
        num[5] = count['f' - 'a'] - num[4];
        num[3] = count['h' - 'a'] - num[8];
        num[7] = count['s' - 'a'] - num[6];
        num[9] = count['i' - 'a'] - num[6] - num[5] - num[8];
        num[1] = count['o' - 'a'] - num[2] - num[4] - num[0];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < num[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}