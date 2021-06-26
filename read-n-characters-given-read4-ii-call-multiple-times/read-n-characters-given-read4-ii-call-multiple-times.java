/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int remain = 0;
    private char[] temp;
    private int readL = 4;
    public int read(char[] buf, int n) {
        int count = 0;
        if (remain != 0) {
            while (remain < readL && count < n) {
                buf[count++] = temp[remain++];
                if (count == n) {
                    return count;
                }
            }
        }
        temp = new char[4];
        while (count < n && readL == 4) {
            readL = read4(temp);
            for (int i = 0; i < readL; i++) {
                buf[count++] = temp[i];
                if (count == n) {
                    remain = i + 1;
                    return count;
                } 
            }
        }
        return count;
    }
}
