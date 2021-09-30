class Solution {
    //at most k
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;
        int left = 0;
        int res = 0;
        int k = 2;
        Map<Integer, Integer> count = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            if (count.getOrDefault(fruits[right], 0) == 0) k--;
            count.put(fruits[right], count.getOrDefault(fruits[right], 0) + 1);
            while (k < 0) {
                if (count.get(fruits[left]) == 1) k++;
                count.put(fruits[left], count.get(fruits[left]) - 1);
                left++;
                
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}