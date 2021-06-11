class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.compute(i, (key,val) -> val == null ? 1 : val + 1);
        }
        int maxlent = Collections.max(count.values());
        List<List<Integer>> l= new ArrayList<>(maxlent + 1);
        for (int i = 0; i < maxlent + 1; i++) {
            l.add(new ArrayList<>());
        }
        for (Integer it : count.keySet()) {
            
            l.get(count.get(it)).add(it);
        }
        int[] result = new int[k];
        int idx = 0;
        for (int i = maxlent; i > 0; i--) {
            for (Integer ij : l.get(i)) {
                if (idx == k) break;
                result[idx++] = ij;
                
            }
        }
        return result;
    }
}