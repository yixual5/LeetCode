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