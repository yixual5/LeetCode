class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }
    
    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || nums[nums.length - 1] * k < target) return result;
        
        if (k == 2) return twoSum(nums, target, start);
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            for (List<Integer> l : kSum(nums, i + 1, k - 1, target - nums[i])) {
               
                l.add(0, nums[i]);
                result.add(l);
            }
        }
        return result;
    }
    
    
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (target > sum || (left > start && nums[left] == nums[left - 1])) {
                left++;
            } else if (target < sum || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                right--;
            } else {
                result.add(new ArrayList<Integer>(Arrays.asList(nums[left++], nums[right--])));
            }
        }
        return result;
    }
}