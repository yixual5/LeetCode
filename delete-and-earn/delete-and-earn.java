class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> count = new HashMap<>();
        int include = 0;
        int notInclude = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        Map<Integer, Integer> count1 = new TreeMap<>();
        count1.putAll(count);
        Iterator<Map.Entry<Integer, Integer>> itr = count1.entrySet().iterator();
        if (itr.hasNext()) {
            Map.Entry<Integer, Integer> temp = itr.next();
            include = temp.getKey() * temp.getValue();
            prev = temp.getKey();
        }
        
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> temp = itr.next();
            int mx = Math.max(include, notInclude);
            if (temp.getKey() == prev + 1) {
                include = notInclude + temp.getKey() * temp.getValue();
                notInclude = mx;
            } else {
                include = mx + temp.getKey() * temp.getValue();
                notInclude = mx;
            }
            prev = temp.getKey();
        }
        
        return Math.max(include, notInclude);
    }
}