class Solution {
    // modify from combination-sum-i
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        LinkedList<Integer> cur = new LinkedList<>();
        backtracking(0, target, candidates, result, cur);
        return result;
    }
    
    private void backtracking (int idx, int remain, int[] candidates, List<List<Integer>> result,
                              LinkedList<Integer> cur) {
        if (remain == 0) {
            //if (!result.contains(cur)) result.add((LinkedList) cur.clone());
            result.add((LinkedList) cur.clone());
            return;
        } else if (remain < 0) {
            return;
        }
        for (int i = idx; i < candidates.length && candidates[i] <= remain; ++i) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            backtracking(i + 1, remain - candidates[i], candidates, result, cur);
            cur.removeLast();
        }
    }
}
