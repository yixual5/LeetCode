class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.compute(i, (key,val) -> val == null ? 1 : val + 1);
        }
        //int maxlent = Collections.max(count.values());
        LinkedList<Integer>[] l= new LinkedList[nums.length];
        /*for (int i = 0; i < maxlent + 1; i++) {
            l.add(new ArrayList<>());
        }*/
        for (Integer it : count.keySet()) {
            // adding the idx reverse the order
            int idx = nums.length - count.get(it);
            if (l[idx] == null) l[idx] = new LinkedList<>();
            l[idx].addFirst(it);
        }
        int[] result = new int[k];
        int idx = 0;
        for (LinkedList<Integer> ls : l) {
            if (ls == null) continue;
            for (Integer ij : ls) {
                if (idx == k) return result;
                result[idx++] = ij;
                
            }
        }
        return result;
    }
}
