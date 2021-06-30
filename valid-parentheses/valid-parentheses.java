// intuitive solution, using stack
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        Stack<Character> ss = new Stack<>();
        ss.push(s.charAt(0));
        Set<Character> l = new HashSet<>(Arrays.asList('(', '{', '['));
        Set<Character> r = new HashSet<>(Arrays.asList(')', '}', ']'));
        
        for (int i = 1; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (l.contains(temp)) {
                ss.push(temp);
            } else {
                if (ss.isEmpty()) return false;
                char temp2 = ss.pop();
                if (temp2 + 2 != temp && temp2 + 1 != temp) return false;
            }
            
        }
        if (!ss.isEmpty()) return false;
        return true;
    }
}

//save some space
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;
        Stack<Character> ss = new Stack<>();
        /*Map <Character, Character> m = new HashMap<>();
        m.put('(', ')');
        m.put('{', '}');
        m.put('[', ']');*/
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[') {
                ss.push(temp);
            } else {
                if (ss.isEmpty()) {
                    return false;
                }
                if ((ss.peek() + 2 != temp && ss.peek() + 1 != temp)) {
                    ss.pop();
                    return false;
                }
                ss.pop();
            }
            
        }
        
        return ss.isEmpty();
    }
}
