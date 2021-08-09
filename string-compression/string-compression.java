// 30 mins, O(n)
class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int left = 0;
        int right = 0;
        while (right < chars.length) {
            char c = chars[right];
            int start = right;
            chars[left] = c;
            while (right < chars.length && chars[right] == c) {
                right++;
            }
            int count = right - start;
            if (count != 1) {
                List<Integer> l = new ArrayList<>();
                while (count > 0) {
                    l.add(count % 10);
                    count /= 10;
                }
                for (int i = l.size() - 1; i >= 0; i--) {
                    chars[++left] = (char)(48 + l.get(i));
                }
                
            }
            left++;
            
        }
        return left;
    }
}
