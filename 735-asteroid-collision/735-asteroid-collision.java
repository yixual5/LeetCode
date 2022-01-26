class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                while (!stack.isEmpty() && asteroid * stack.getLast() < 0 && asteroid + stack.getLast() < 0)  stack.removeLast();
                if (stack.isEmpty() || stack.getLast() * asteroid > 0) stack.addLast(asteroid);
                else if (!stack.isEmpty() && stack.getLast() + asteroid == 0) stack.removeLast();
            } else {
                stack.addLast(asteroid);
            }
            
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) res[i] = stack.removeFirst();
        return res;
    }
}