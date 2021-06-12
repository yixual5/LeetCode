class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> mx = new HashSet<>();
        for (int num : nums) {
            mx.add(num);
            if (mx.size() > 3) {
                mx.remove(Collections.min(mx));
            }
        }
        if (mx.size() == 3) return Collections.min(mx);
        return Collections.max(mx);
    }
}