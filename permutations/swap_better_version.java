class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //Set<Integer> cur = new LinkedHashSet<>(); //order matters
        
        backtracking(result, nums, 0);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, int[] nums, int idx){
        if (idx == nums.length) {
            LinkedList<Integer> t = new LinkedList<>();
            for (int num : nums) {
                t.add(num);
            }
            result.add(t);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            this.swap(nums, idx, i);
            backtracking(result, nums, idx + 1); //fix the first one
            this.swap(nums, idx, i); //backtrack
        }
    }
    
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
