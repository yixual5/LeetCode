class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int i = 0;
        int j = nums.length - 1;
        while (i <= nums.length / 2 && j >= nums.length / 2) {
            m.put(nums[i], i);
            m.put(nums[j], j);
            if (m.containsKey(target - nums[i]) && m.get(target - nums[i]) != i) {
                return new int[]{i, m.get(target - nums[i])};
            }
            if (m.containsKey(target - nums[j]) && m.get(target - nums[j]) != j) {
                return new int[]{j, m.get(target - nums[j])};
            }
            j--;
            i++;
        }
        return null;
    }
}