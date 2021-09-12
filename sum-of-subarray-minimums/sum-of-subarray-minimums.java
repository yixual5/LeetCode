class Solution {
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> prev = new ArrayDeque<>();
        Deque<Integer> next = new ArrayDeque<>();
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!prev.isEmpty() && arr[prev.peek()] >= arr[i]) prev.pop();
            left[i] = prev.isEmpty() ? i + 1 : i - prev.peek();
            prev.push(i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!next.isEmpty() && arr[next.peek()] > arr[i]) next.pop();
            right[i] = next.isEmpty() ? arr.length - i : next.peek() - i;
            next.push(i);
        }
        long ans = 0;
        for (int i = 0; i < left.length; i++) {
            // the formula is based on that for left side
            // we have left elements include i
            // for left, we have right choice
            // total is left * right
            ans = (ans + (long) right[i] * left[i] * arr[i]) % 1000000007;
        }
        return (int) ans;
    }
}