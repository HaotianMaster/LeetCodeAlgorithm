/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4]; // temp buffer
        int total = 0;   // total bytes have read
        while (total < n) {
            int count = read4(temp);
            // check if it's the end of the file
            if (count == 0) break;
            // get the actual count, n maybe greater than the number of characters in the file or less than.
            count = Math.min(count, n - total);
            // copy from temp buffer to buf
            for (int i = 0; i < count; i++) {
                buf[total++] = temp[i];
            }
        }
        return total;
    }
}


/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int total = 0, idx = 0;
        while (total < n) {
            int count = read4(temp);
            if (count == 0) break;
            while (total < n && idx < count) {
                buf[total++] = temp[idx++];
            }
            if (idx == count) idx = 0;
        }
        return total;
    }
}




/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        char[] buf4 = new char[4];
        while (total < n) {
            int count = read4(buf4);
            if (count == 0) break;
            for (int i = 0; i < count && total < n; i++) {
                buf[total++] = buf4[i];
            }
        }
        return total;
    }
}



