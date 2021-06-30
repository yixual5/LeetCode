class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) return true;
        char[] ord = order.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        int j = 0;
        for (char c : ord) {
            m.put(c, j++);
        }
        
        for (int i = 1; i < words.length; i++) {
            String temp = words[i];
            char[] temp1 = temp.toCharArray();
            char[] temp2 = words[i - 1].toCharArray();
            int k = 0;
            boolean b = false;
            while (k < temp1.length && k < temp2.length) {
                if (temp1[k] == temp2[k]) {
                    k++;
                    continue;
                }
                if (m.get(temp1[k]) < m.get(temp2[k])) {
                    return false;
                }
                b = true;
                break;
            }
            if (!b && temp1.length < temp2.length) return false;
        }
        return true;
    }
}