class Solution {
    // backtracking, easy to implement
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        LinkedList<Integer> cur = new LinkedList<>();
        int idx = 0;
        backtracking(nums, result, cur, idx);
        return result;
    }
    
    private void backtracking (int[] nums, List<List<Integer>> result,                  LinkedList<Integer> cur, int idx) {
        result.add((LinkedList) cur.clone());
        if (idx == nums.length) return;
        for (int i = idx; i < nums.length; ++i) {
            cur.add(nums[i]);
            backtracking(nums, result, cur, i + 1);
            cur.removeLast();
        }
    }
}
