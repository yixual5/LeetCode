class Solution {
    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int max = 0;

        int[] visited = new int[128];
        //Map<Character, Integer> visited = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (/*visited.containsKey(c)*/ visited[c] >= begin) {
                max = Math.max(max, i - begin);
                begin = visited[c];
            }
            visited[c] = i + 1;
            max = Math.max(max, i - begin + 1);
        }
        return max;
    }
}