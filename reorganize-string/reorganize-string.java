class Solution {
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> count = new HashMap<>();
        char[] stoc = s.toCharArray();
        for (char c : stoc) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((a1, a2) -> a2.getValue() - a1.getValue());
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            q.offer(entry);
        }
        StringBuffer sb = new StringBuffer();
        Map.Entry<Character,Integer> prev = Map.entry('a', 0);
        while (!q.isEmpty()) {
            Map.Entry<Character,Integer> cur = q.poll();
            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            if (prev.getValue() > 0) q.offer(prev);
            prev = cur;
        }
        if (sb.length() != s.length()) return "";
        return sb.toString();
    }
}

// fill with largest count first, then the rest can easily be filled if largest count not exceed the half of string size
class Solution {
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";
        int[] count = new int[26];
        char[] temp = s.toCharArray();
        int max = 0;
        char maxChar = 'a';
        for (char c: temp) {
            count[c - 'a']++;
            if (count[c - 'a'] > max) {
                maxChar = c;
                max = count[c - 'a'];
            }
        }
        // cannot seperate the maxChar with a space
        if (max > (s.length() + 1) / 2) return "";
        char[] result = new char[s.length()];
        int idx = 0;
        while (count[maxChar - 'a'] > 0) {
            result[idx] = maxChar;
            count[maxChar - 'a']--;
            idx += 2; //seperate with a space
        }
        if (idx > s.length() - 1) idx = 1;
        
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                result[idx] = (char) (i + 'a');
                count[i]--;
                idx += 2;
                if (idx > s.length() - 1) idx = 1;
            }
        }
        return new String(result);
    }
}
