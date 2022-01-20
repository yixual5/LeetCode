class Solution {
    public double angleClock(int hour, int minutes) {
        double pos_hour = (double) minutes / 60 + hour % 12;
        double pos_mins = (double) minutes / 5;
        double diff = Math.abs(pos_hour - pos_mins);
        return diff > 6 ? 360 - diff * 30 : diff * 30;
    }
}