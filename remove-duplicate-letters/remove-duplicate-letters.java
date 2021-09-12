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

//using stringbuffer as a stack
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        boolean[] visited = new boolean[26];
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (!visited[c - 'a']) {
                while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
                visited[c - 'a'] = true;
                sb.append(c);
                
            }
            
        }
        return sb.toString();
    }
}
