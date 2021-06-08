class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> check = new HashSet<>();
        HashSet<Integer> check2 = new HashSet<>();
        for (int i : nums1) check.add(i);
        for (int i : nums2) check2.add(i);
        check.retainAll(check2);
        int[] result = new int[check.size()];
        int idx = 0;
        for (int i: check) result[idx++] = i;
        return result;
    }
}