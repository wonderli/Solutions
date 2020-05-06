import java.util.*;
public class Solution{
    private int[] array;
    private int[] original;
    private Random rand;
    public Solution(int[] nums){
        array = nums;
        original = nums.clone();
        rand = new Random();
    }

    public int[] reset(){
        array = original;
        original = original.clone();
        return original;
    }
    public void swap(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public int rand(int start, int end){
        return rand.nextInt(end - start) + start;
    }
    public int[] shuffle(){
        for(int i = 0; i < array.length; i++){
            swap(i, rand(i, array.length));
        }
        return array;
    }
    public static void main(String args[]){
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
