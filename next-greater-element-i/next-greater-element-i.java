class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        Deque<Integer> s = new ArrayDeque<>();
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num2 : nums2) {
            while (!s.isEmpty() && s.peek() < num2) {
                map.put(s.pop(), num2);
            }
            s.push(num2);
        }
        while (!s.isEmpty()) map.put(s.pop(), -1);
        for (int i = 0; i < nums1.length; i++) result[i] = map.get(nums1[i]);
        return result;
        
    }
}