class Solution {
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int result = 0;
        Deque<Integer> s = new ArrayDeque<>();
        s.push(Integer.MAX_VALUE);
        for (int num : arr) {
            while (!s.isEmpty() && num > s.peek()) {
                int mid = s.pop();
                result += Math.min(num, s.peek()) * mid;
            }
            s.push(num);
        }
        while (s.size() > 2) {
            result += s.pop() * s.peek();
        }
        return result;
    }
}