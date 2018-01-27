import java.util.*;
public class Solution{
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        char[] arr = s.toCharArray();
        int len = arr.length;
        int left = 0;
        int right = len-1;
        int max = num;
        int pos = right;
        while(left < len){
            while(right > left){
                if(arr[left] < arr[right]){
                    if(arr[right] > arr[pos]){
                        pos = right;
                    }
                }
                right--;
            }
            int n = swap(s, left, pos);
            right = len - 1;
            pos = right;
            if(n > max){
                max = n;
            }
            left++;
        }
        return max;
    }
    public int swap(String s, int i, int j){
        char[] a = s.toCharArray();
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        String newString = String.valueOf(a);
        return Integer.parseInt(newString);
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        System.out.println(sol.maximumSwap(98368));
        System.out.println(sol.maximumSwap(99901));
        System.out.println(sol.maximumSwap(99098));
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
