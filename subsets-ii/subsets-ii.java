class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        LinkedList<Integer> cur = new LinkedList<>();
        int idx = 0;
        Arrays.sort(nums);
        backtracking(nums, result, cur, idx);
        return result;
    }
    
    private void backtracking (int[] nums, List<List<Integer>> result,                  LinkedList<Integer> cur, int idx) {
        result.add((LinkedList) cur.clone());
        if (idx == nums.length) return;
        for (int i = idx; i < nums.length; ++i) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            backtracking(nums, result, cur, i + 1);
            cur.removeLast();
        }
    }
}
