// O(N) time complexity and space, using stack as extra space, count array is also ok, 1 hr
class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || k == 1) return null;
        if (s.length() == 0) return s;
        Stack<Integer> st = new Stack<>();
        char[] c = s.toCharArray();
        int j = 0;
        for (int i = 0; i < c.length; i++, j++) {
            c[j] = c[i];
            if (j != 0 && c[j] == c[j - 1]) {
                int temp = st.pop() + 1;
                if (temp == k) {
                    j = j - k;
                } else {
                    st.push(temp);
                }
            } else {
                st.push(1);
            }
        }
        return new String(c, 0, j);
    }
}
