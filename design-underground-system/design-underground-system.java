//O(1) runtime, O(number of stations^2 + number of passenger on the train)
class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> start;
    Map<String, int[]> count;
    public UndergroundSystem() {
        start = new HashMap<>();
        count = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        start.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        int startTime = start.get(id).getValue();
        String depature = start.get(id).getKey();
        int[] temp = count.getOrDefault(depature + "," + stationName, new int[]{0,0});
        int allTime = t - startTime + temp[0];
        int countt = temp[1] + 1;
        count.put(depature + "," + stationName, new int[]{allTime, countt});
        start.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] temp = count.get(startStation + "," + endStation);
        return 1.0 * temp[0] / temp[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
