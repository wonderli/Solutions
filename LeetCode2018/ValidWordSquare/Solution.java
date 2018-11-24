import java.util.*;
public class Solution{
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0) return false;
        int size = 500;
        char matrix[][] = new char[size][size];
        for(int i = 0; i < size; i++){
            String s = i < words.size() ? words.get(i) : "";
            int sLen = s.length();
            for(int j = 0; j < size; j++){
                matrix[i][j] = j < sLen ? s.charAt(j) : ' ';
            }
        }
        for(int i = 0; i < size; i++){
            String r = i < words.size() ? words.get(i).trim() : "";
            String c = getCol(matrix, size, i).trim();
            if(!r.equals(c)){
                return false;
            }
        }
        return true;
    }
    public String getCol(char[][] matrix, int size, int index){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < size; i++){
            sb.append(matrix[i][index]);
        }
        return sb.toString();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
        List<String> s = new ArrayList<>();
        //s.add("abcd");
        //s.add("bnrt");
        //s.add("crm");
        //s.add("dt");
        //s.add("abc");
        //s.add("b");
        s.add("aa");
        s.add("ad");
        s.add("ad");
        System.out.println(sol.validWordSquare(s));
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
