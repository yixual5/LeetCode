class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        if (s == null || s.length() == 0) return s;
        
        Deque<Character> stack = new ArrayDeque<>();
        char[] c = s.toCharArray();
        int count = 0;
        for (char cc : c) count += cc == letter ? 1 : 0;
        if (count < repetition) return null;
        int extra = count - repetition;
        int i;
        for (i = 0; i < c.length; i++) {
            while (!stack.isEmpty() && stack.peek() > c[i] && k - stack.size() < c.length - i) {
                if (stack.peek() == letter) {
                    if (count - repetition > 0) {
                        repetition++;
                        stack.pop();
                    } else {
                        break;
                    }
                } else {
                    stack.pop();
                }
                
            }
            if (stack.size() < k) {
                if (c[i] == letter) {
                    stack.push(c[i]);
                    repetition--;
                } else if (k - stack.size() > repetition) {
                    stack.push(c[i]);
                }
            }
            if (c[i] == letter) count--;
                
            
            
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) sb.append(stack.removeLast());
        return sb.toString();
        
    }
}