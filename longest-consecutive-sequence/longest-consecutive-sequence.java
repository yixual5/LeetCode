//O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums) s.add(num);
        int max = 0;
        for (int num : nums) {
            if (s.contains(num - 1)) continue;
            int cur = 1;
            while (s.contains(num + 1)) {
                cur++;
                num++;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
