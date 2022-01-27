class Solution {
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> s = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        long res = 0;
        long mode = (long) 1e9 + 7;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.getLast()] > arr[i]) {
                right[s.getLast()] = i - s.removeLast();
            }
            if (!s.isEmpty()) left[i] = i - s.getLast();
            else left[i] = i + 1;
            s.addLast(i);
        }
        while (!s.isEmpty()) right[s.getLast()] = arr.length - s.removeLast();
        /*for (int i = arr.length - 1; i >= 0; i--) {
            while (!s2.isEmpty() && arr[s2.getLast()] >= arr[i]) s2.removeLast();
            if (!s2.isEmpty()) right[i] = s2.getLast() - i;
            else right[i] = arr.length - i;
            s2.addLast(i);
        }*/
        for (int i = 0; i < arr.length; i++) res = (res + (long) arr[i] * left[i] * right[i]) % mode;
        return (int) res;
    }
}