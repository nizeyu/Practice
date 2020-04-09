/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readBytes = 0;
        
        while (readBytes < n && !endOfFile) {
            int curReadBytes = read4(buffer);
            
            if (curReadBytes != 4) {
                endOfFile = true;
            }
            
            int length = Math.min(curReadBytes, n - readBytes);
            for (int i = 0; i < length; i++) {
                buf[readBytes + i] = buffer[i];
            }
            
            readBytes += length;
        }
        
        return readBytes;
    }
}
