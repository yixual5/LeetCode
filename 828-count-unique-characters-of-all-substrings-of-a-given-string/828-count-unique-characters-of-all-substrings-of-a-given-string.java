class Solution {
    public int uniqueLetterString(String s) {
        int[][] lastPosition = new int[26][2];
        for(int[] i : lastPosition) i[0] = -1;
        int[] res = new int[s.length()];
        lastPosition[s.charAt(0) - 'A'][0] = 0;
        lastPosition[s.charAt(0) - 'A'][1] = 1;
        res[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';
            res[i] = res[i - 1] - lastPosition[idx][1] + (i - lastPosition[idx][0]);
            lastPosition[idx][1] = i - lastPosition[idx][0];
            lastPosition[idx][0] = i;

        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) sum+= res[i];
        return sum;
    }
}