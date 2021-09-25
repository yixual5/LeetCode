class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if ((nums == null || nums.length == 0) && k != 0) return 0;
        return atMostK(k, nums) - atMostK(k - 1, nums);
        
    }
    
    private int atMostK(int k, int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (count.getOrDefault(nums[right], 0) == 0) k--;
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
            while (k == -1) {
                if (count.get(nums[left]) == 1) k++;
                count.put(nums[left], count.get(nums[left]) - 1);
                left++;
            }
            result += right - left + 1; //# of subarrays with at most k distinct
        }
        return result;
    }
}