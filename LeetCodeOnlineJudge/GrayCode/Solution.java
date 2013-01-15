//The gray code is a binary numeral system where two successive values differ in only one bit.
//
//Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//
//For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//
//00 - 0
//01 - 1
//11 - 3
//10 - 2
import java.util.*;
public class Solution{
//    public ArrayList<Integer> grayCode(int n) {
//        ArrayList<Integer> ret = new ArrayList<Integer>();
//        ret.add(0);
//        for(int i = 1; i <= n; i++){
//            int a = 1 << (i - 1);
//            for(int j = ret.size(); j >= 0; j--){
//                ret.add(ret.get(j)|a);
//            }
//        }
//        return ret;
//    }
    public ArrayList<Integer> grayCode(int n){
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(n == 0) {
            al.add(0);
            return al;
        }
        al.add(0);
        al.add(1);
        int i = 1;
        while(i < n){
            reflect(al);
            int len = al.size();
            for(int j = 0; j < len; j++){
                int val = 1;
                if(j < len/2){
                    val = 0;
                }
                Integer curr = al.get(j);
                int currInt = curr.intValue();
                currInt = setBit(currInt, i, val);
                al.set(j, new Integer(currInt));
            }
            i++;
        }
        return al;
    }
    public void reflect(ArrayList<Integer> al){
        for(int i = al.size() - 1; i>=0; i--){
            al.add(al.get(i));
        }
    }
    public int setBit(int num, int pos, int val){
        num = num|(val << pos);
        return num;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int n = 3;
        ArrayList<Integer> r = s.grayCode(n);
        System.out.println(r.toString());
    }
}
