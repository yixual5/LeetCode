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
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int itr = n % 4 == 0 ? n / 4 : n / 4 + 1;
        
        int count = 0;
        for (int i = 0; i < itr; i++) {
            int curc = read4(temp);
            count += curc;
            for (int j = 0; j < curc; j++) {
                if (i * 4 + j == n) {
                    
                    return n;
                }
                buf[i * 4 + j] = temp[j];
            }
            if (curc < 4) return count;
        }
        return count;
    }
}

//cleaner sol
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
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int readL = 4; int count = 0;
        while (count < n && readL == 4) {
            readL = read4(temp);
            for (int i = 0; i < readL; i++) {
                buf[count++] = temp[i];
                if (count == n) return count;
            }
        }
        return count;
    }
}
