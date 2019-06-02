import java.util.*;
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
        if(buf == null || buf.length == 0) {
            return 0;
        }
        char[] buff = new char[4];
        int j = 0;
        int times = n/4;
        int leftOver = n%4;
        for(int i = 0; i < times; i++){
            int r = read4(buff);
            for(int k = 0; k < r; k++){
                buf[j] = buff[k];
                j++;
            }
        }
        int m = read4(buff);
        for(int p = 0; p < Math.min(leftOver, m); p++){
            buf[j] = buff[p];
            j++;
        }
        return j;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
