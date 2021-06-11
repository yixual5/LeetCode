class Solution {
    // optimal solution with O(n)
    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c: s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int maxlength = Collections.max(count.values());
        List<List<Character>> l= new ArrayList<>(maxlength);
        for (int i = 0; i < maxlength + 1; i++) {
            l.add(new ArrayList<Character>());
        }
        for (Character c : count.keySet()) {
            l.get(count.get(c)).add(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = l.size() - 1; i > 0; i--) {
            for (Character c: l.get(i)) {
                
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
                
            }
        }
        return sb.toString();
    }
}
