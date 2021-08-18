class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                count.put(num1 + num2, count.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        int result = 0;
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                result += count.getOrDefault(-(num3 + num4), 0);
            }
        }
        return result;
    }
}