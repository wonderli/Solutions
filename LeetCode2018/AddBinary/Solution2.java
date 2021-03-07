import java.util.*;
class Solution{
    public String addBinary(String a, String b) {
        if(a == null) return b;
        if(b == null) return a;
        int aLen = a.length();
        int bLen = b.length();
        int i = aLen - 1;
        int j = bLen - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            int aValue = i >= 0 ? a.charAt(i) - '0' : 0;
            int bValue = j >= 0 ? b.charAt(j) - '0' : 0;
            int cValue = (aValue + bValue + carry) % 2;
            carry = (aValue + bValue + carry)/2;
            sb.append(cValue);
            i--;
            j--;
        }
        if(carry != 0){
            sb.append(carry);
        }

        sb.reverse();
        return sb.toString();
    }
    public static void main(String args[]){
        Solution sol = new Solution();
    }
}