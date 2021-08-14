class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        char[] stoc = s.toCharArray();
        int prev = m.get(stoc[0]);
        int result = 0;
        for (int i = 1; i < stoc.length; i++) {
            int cur = m.get(stoc[i]);
            if (prev < cur) {
                result += - prev;
            } else {
                result += prev;
            }
            prev = cur;
        }
        return result + prev;
    }
}