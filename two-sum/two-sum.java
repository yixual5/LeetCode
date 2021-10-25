class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        Map<Integer, Integer> check = new HashMap<>();
        while (i <= j) {
            if (nums[i] + nums[j] == target) return new int[]{i, j};
            int iComplement = check.getOrDefault(target - nums[i], - 1);
            if (iComplement != -1) {
                return new int[] {i, iComplement};
            }
            int jComplement = check.getOrDefault(target - nums[j], - 1);
            if (jComplement != -1) {
                return new int[] {j, jComplement};
            }
            check.put(nums[i], i++);
            check.put(nums[j], j--);
        }
        return null;
    }
}