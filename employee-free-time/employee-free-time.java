/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        if (schedule == null || schedule.size() == 0) return result;
        Map<Integer, Integer> count = new TreeMap<>();
        for (List<Interval> l : schedule) {
            for (Interval inv : l) {
                count.put(inv.start, count.getOrDefault(inv.start, 0) + 1);
                count.put(inv.end, count.getOrDefault(inv.end, 0) - 1);
            }
        }
        int cot = 0;
        Interval temp = new Interval();
        boolean start = false;
        for (Integer k : count.keySet()) {
            cot += count.get(k);
            if (cot == 0) {
                if (!start) {
                    temp.start = k;
                    start = true;
                }
            } else {
                if (start) {
                    temp.end = k;
                    result.add(temp);
                    temp = new Interval();
                    start = false;
                }
            }
        }
        return result;
    }
}