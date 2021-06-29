class Solution {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        int n = words.length;
        while (idx < n) {
            int total = 0;
            total += words[idx].length();
            int last = idx + 1;
            while (last < n) {
                if (total + words[last].length() + 1 > maxWidth) break;
                total += words[last++].length() + 1;
            }
            
            StringBuffer sb = new StringBuffer();
            if (last == n || last - idx == 1) {
                
                for (int i = idx; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                sb.setLength(total);
                while (total + 1 <= maxWidth) {
                    sb.append(' ');
                    total++;
                }
            } else {
                
                int gap = last - idx - 1;
                int space = (maxWidth - total) / gap;
                int remain = (maxWidth - total) % gap;
                for (int i = idx; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                    for (int j = 0; j < space + (i - idx < remain ? 1 : 0); j++) {
                        sb.append(' ');
                    }
                }
                sb.append(words[last - 1]);
            }
            result.add(sb.toString());
            idx = last;
        }
        return result;
    }
}
