/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int count = 0;
    int index = 0;
    char[] buf4 = new char[4]; // temp buffer
    public int read(char[] buf, int n) {
        int total = 0;
        while (total < n) {
            if (index == 0) {
                count = read4(buf4);
            }
            if (count == 0) break;
            while (total < n && index < count) {
                buf[total++] = buf4[index++];
            }
            if (index == count) index = 0;
        }
        return total;
    }
}