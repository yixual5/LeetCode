class Solution {
    // another backtracking
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        
        backtracking(result, cur, nums);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, LinkedList<Integer> cur,                                      int[] nums){
        if (cur.size() == nums.length) {
            result.add((LinkedList) cur.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            backtracking(result, cur, nums);
            cur.removeLast();
        }
    }
}
