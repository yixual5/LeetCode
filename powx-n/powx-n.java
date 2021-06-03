class Solution {
    public double myPow(double x, int n) {
        if (n < 0) x = 1/x;
        return Pow(x, n);
    }
    
    private double Pow(double x, int n) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
            double temp = Pow(x, n/2);
            return temp * temp;
        } else {
            double temp = Pow(x, n/2);
            return temp * temp * x;
        }
    }
}