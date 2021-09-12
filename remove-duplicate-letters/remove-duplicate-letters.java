class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (!visited[c - 'a']) {
                while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                    visited[stack.pop() - 'a'] = false;
                }
                visited[c - 'a'] = true;
                stack.push(c);
                
            }
            
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}